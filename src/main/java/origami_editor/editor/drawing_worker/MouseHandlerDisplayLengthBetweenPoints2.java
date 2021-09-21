package origami_editor.editor.drawing_worker;

import origami.crease_pattern.OritaCalc;
import origami.crease_pattern.element.Point;
import origami_editor.editor.MouseMode;

public class MouseHandlerDisplayLengthBetweenPoints2 extends BaseMouseHandler{
    private final MouseHandlerPolygonSetNoCorners mouseHandlerPolygonSetNoCorners;

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.DISPLAY_LENGTH_BETWEEN_POINTS_2_54;
    }

    //マウス操作(マウスを動かしたとき)を行う関数
    public void mouseMoved(Point p0) {
        mouseHandlerPolygonSetNoCorners.mouseMoved(p0);
    }//近い既存点のみ表示

    //マウス操作(ボタンを押したとき)時の作業
    public void mousePressed(Point p0) {
        Point p = new Point();
        p.set(d.camera.TV2object(p0));
        d.closest_point.set(d.getClosestPoint(p));
        if (p.distance(d.closest_point) < d.selectionDistance) {
            d.i_drawing_stage = d.i_drawing_stage + 1;
            d.line_step[d.i_drawing_stage].set(d.closest_point, d.closest_point);
            d.line_step[d.i_drawing_stage].setColor(d.lineColor);
        }
    }

    //マウス操作(ドラッグしたとき)を行う関数
    public void mouseDragged(Point p0) {
    }

    public MouseHandlerDisplayLengthBetweenPoints2(DrawingWorker d) {
        super(d);
        mouseHandlerPolygonSetNoCorners = new MouseHandlerPolygonSetNoCorners(d);
    }

    //マウス操作(ボタンを離したとき)を行う関数
    public void mouseReleased(Point p0) {
        if (d.i_drawing_stage == 2) {
            d.i_drawing_stage = 0;
            d.app.measuresModel.setMeasuredLength2(OritaCalc.distance(d.line_step[1].getA(), d.line_step[2].getA()) * (double) d.grid.getGridSize() / 400.0);
        }
    }
}
