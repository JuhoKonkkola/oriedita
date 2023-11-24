package oriedita.editor.handler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import oriedita.editor.canvas.CreasePattern_Worker;
import oriedita.editor.canvas.MouseMode;
import origami.crease_pattern.OritaCalc;
import origami.crease_pattern.element.LineColor;
import origami.crease_pattern.element.LineSegment;
import origami.crease_pattern.element.Point;
import origami.crease_pattern.element.Polygon;

@ApplicationScoped
@Handles(MouseMode.OPERATION_FRAME_CREATE_61)
public class MouseHandlerOperationFrameCreate extends BaseMouseHandler {
    CreasePattern_Worker.OperationFrameMode operationFrameMode;

    @Inject
    public MouseHandlerOperationFrameCreate() {
    }

    //マウス操作(マウスを動かしたとき)を行う関数
    public void mouseMoved(Point p0) {
        if (d.getGridInputAssist()) {
            d.getLineCandidate().clear();

            Point p = d.getCamera().TV2object(p0);
            Point closest_point = d.getClosestPoint(p);

            if (p.distance(closest_point) < d.getSelectionDistance()) {
                d.getLineCandidate().add(new LineSegment(closest_point, closest_point, LineColor.GREEN_6));
            } else {
                d.getLineCandidate().add(new LineSegment(p, p, LineColor.GREEN_6));
            }

            d.getLineCandidate().get(0).setActive(LineSegment.ActiveState.ACTIVE_BOTH_3);
        }
    }

    //マウス操作(mouseMode==61　長方形内選択でボタンを押したとき)時の作業----------------------------------------------------
    public void mousePressed(Point p0) {
        Point p = d.getCamera().TV2object(p0);
        Point p_ob1 = d.getCamera().TV2object(d.getOperationFrame_p1());
        Point p_ob2 = d.getCamera().TV2object(d.getOperationFrame_p2());
        Point p_ob3 = d.getCamera().TV2object(d.getOperationFrame_p3());
        Point p_ob4 = d.getCamera().TV2object(d.getOperationFrame_p4());

        double distance_min = 100000.0;

        operationFrameMode = CreasePattern_Worker.OperationFrameMode.NONE_0;
        if (d.getLineStep().size() == 0) {
            operationFrameMode = CreasePattern_Worker.OperationFrameMode.CREATE_1;
        }
        Point p_new;
        if (d.getLineStep().size() == 4) {
            if (d.getOperationFrameBox().inside(p0) == Polygon.Intersection.OUTSIDE) {
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.CREATE_1;
            } else {
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_BOX_4;
            }


            distance_min = OritaCalc.min(OritaCalc.determineLineSegmentDistance(p, p_ob1, p_ob2), OritaCalc.determineLineSegmentDistance(p, p_ob2, p_ob3), OritaCalc.determineLineSegmentDistance(p, p_ob3, p_ob4), OritaCalc.determineLineSegmentDistance(p, p_ob4, p_ob1));
            if (distance_min < d.getSelectionDistance()) {
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_SIDES_3;
            }


            if (p.distance(p_ob1) < d.getSelectionDistance()) {
                p_new = d.getOperationFrame_p1();
                d.setOperationFramePoint(1, d.getOperationFrame_p3());
                d.setOperationFramePoint(3, p_new);
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_POINTS_2;
            }
            if (p.distance(p_ob2) < d.getSelectionDistance()) {
                p_new = d.getOperationFrame_p2();
                d.setOperationFramePoint(2, d.getOperationFrame_p1());
                d.setOperationFramePoint(1, d.getOperationFrame_p4());
                d.setOperationFramePoint(4, d.getOperationFrame_p3());
                d.setOperationFramePoint(3, p_new);
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_POINTS_2;
            }
            if (p.distance(p_ob3) < d.getSelectionDistance()) {
                p_new = d.getOperationFrame_p3();
                d.setOperationFramePoint(1, d.getOperationFrame_p1());
                d.setOperationFramePoint(3, p_new);
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_POINTS_2;
            }
            if (p.distance(p_ob4) < d.getSelectionDistance()) {
                p_new = d.getOperationFrame_p4();
                d.setOperationFramePoint(4, d.getOperationFrame_p1());
                d.setOperationFramePoint(1, d.getOperationFrame_p2());
                d.setOperationFramePoint(2, d.getOperationFrame_p3());
                d.setOperationFramePoint(3, p_new);
                operationFrameMode = CreasePattern_Worker.OperationFrameMode.MOVE_POINTS_2;
            }

        }

        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.MOVE_SIDES_3) {
            while (OritaCalc.determineLineSegmentDistance(p, p_ob1, p_ob2) != distance_min) {
                p_new = d.getOperationFrame_p1();
                d.setOperationFramePoint(1, d.getOperationFrame_p2());
                d.setOperationFramePoint(2, d.getOperationFrame_p3());
                d.setOperationFramePoint(3, d.getOperationFrame_p4());
                d.setOperationFramePoint(4, p_new);
                p_new = p_ob1;
                p_ob1 = p_ob2;
                p_ob2 = p_ob3;
                p_ob3 = p_ob4;
                p_ob4 = p_new;
            }

        }

        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.CREATE_1) {
            d.getLineStep().clear();
            d.lineStepAdd(new LineSegment());
            d.lineStepAdd(new LineSegment());
            d.lineStepAdd(new LineSegment());
            d.lineStepAdd(new LineSegment());

            p_new = p;

            Point closest_point = d.getClosestPoint(p);

            if (p.distance(closest_point) < d.getSelectionDistance()) {
                p_new = closest_point;

            }

            d.setOperationFramePoint(1, d.getCamera().object2TV(p_new));
            d.setOperationFramePoint(2, d.getCamera().object2TV(p_new));
            d.setOperationFramePoint(3, d.getCamera().object2TV(p_new));
            d.setOperationFramePoint(4, d.getCamera().object2TV(p_new));
        }
    }

    //マウス操作(mouseMode==61　長方形内選択でドラッグしたとき)を行う関数----------------------------------------------------
    public void mouseDragged(Point p0) {

        Point p = d.getCamera().TV2object(p0);
        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.MOVE_POINTS_2) {
            operationFrameMode = CreasePattern_Worker.OperationFrameMode.CREATE_1;
        }

        Point p_new = new Point();

        if (!d.getGridInputAssist()) {
            p_new = p;
        }

        if (d.getGridInputAssist()) {
            d.getLineCandidate().clear();

            Point closest_point = d.getClosestPoint(p);
            if (p.distance(closest_point) < d.getSelectionDistance()) {
                d.getLineCandidate().add(new LineSegment(closest_point, closest_point, LineColor.GREEN_6));
            } else {
                d.getLineCandidate().add(new LineSegment(p, p, LineColor.GREEN_6));
            }
            d.getLineCandidate().get(0).setActive(LineSegment.ActiveState.ACTIVE_BOTH_3);

            p_new = d.getLineCandidate().get(0).getA();
        }


        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.MOVE_SIDES_3) {
            if (
                    (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX()) * (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX())
                            <
                            (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY()) * (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY())
            ) {
                d.getOperationFrame_p1().setX(d.getCamera().object2TV(p_new).getX());
                d.getOperationFrame_p2().setX(d.getCamera().object2TV(p_new).getX());
            }

            if (
                    (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX()) * (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX())
                            >
                            (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY()) * (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY())
            ) {
                d.getOperationFrame_p1().setY(d.getCamera().object2TV(p_new).getY());
                d.getOperationFrame_p2().setY(d.getCamera().object2TV(p_new).getY());
            }

        }


        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.CREATE_1) {
            d.setOperationFramePoint(3, d.getCamera().object2TV(p_new));
            d.setOperationFramePoint(2, new Point(d.getOperationFrame_p1().getX(), d.getOperationFrame_p3().getY()));
            d.setOperationFramePoint(4, new Point(d.getOperationFrame_p3().getX(), d.getOperationFrame_p1().getY()));
        }
    }

//--------------------

    //マウス操作(mouseMode==61 長方形内選択　でボタンを離したとき)を行う関数----------------------------------------------------
    public void mouseReleased(Point p0) {

        Point p = d.getCamera().TV2object(p0);

        Point p_new = p;

        Point closest_point = d.getClosestPoint(p);
        if (p.distance(closest_point) <= d.getSelectionDistance()) {
            p_new = closest_point;/*line_step[1].seta(moyori_ten);*/
        }

        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.MOVE_SIDES_3) {
            if (
                    (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX()) * (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX())
                            <
                            (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY()) * (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY())
            ) {
                d.getOperationFrame_p1().setX(d.getCamera().object2TV(p_new).getX());
                d.getOperationFrame_p2().setX(d.getCamera().object2TV(p_new).getX());
            }

            if (
                    (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX()) * (d.getOperationFrame_p1().getX() - d.getOperationFrame_p2().getX())
                            >
                            (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY()) * (d.getOperationFrame_p1().getY() - d.getOperationFrame_p2().getY())
            ) {
                d.getOperationFrame_p1().setY(d.getCamera().object2TV(p_new).getY());
                d.getOperationFrame_p2().setY(d.getCamera().object2TV(p_new).getY());
            }

        }

        if (operationFrameMode == CreasePattern_Worker.OperationFrameMode.CREATE_1) {
            d.setOperationFramePoint(3, d.getCamera().object2TV(p_new));
            d.setOperationFramePoint(2, new Point(d.getOperationFrame_p1().getX(), d.getOperationFrame_p3().getY()));
            d.setOperationFramePoint(4, new Point(d.getOperationFrame_p3().getX(), d.getOperationFrame_p1().getY()));
        }

        d.getOperationFrameBox().set(1, d.getOperationFrame_p1());
        d.getOperationFrameBox().set(2, d.getOperationFrame_p2());
        d.getOperationFrameBox().set(3, d.getOperationFrame_p3());
        d.getOperationFrameBox().set(4, d.getOperationFrame_p4());

        if (d.getOperationFrameBox().calculateArea() * d.getOperationFrameBox().calculateArea() < 1.0) {
            d.getLineStep().clear();
        }
    }
}
