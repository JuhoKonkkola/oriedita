package origami_editor.editor.drawing_worker;

import origami.crease_pattern.element.Point;
import origami_editor.editor.MouseMode;

public class MouseHandlerCreaseSelect extends BaseMouseHandler{
    private final MouseHandlerCreaseMove4p mouseHandlerCreaseMove4p;
    private final MouseHandlerCreaseCopy4p mouseHandlerCreaseCopy4p;
    private final MouseHandlerCreaseCopy mouseHandlerCreaseCopy;
    private final MouseHandlerCreaseMove mouseHandlerCreaseMove;
    private final MouseHandlerDrawCreaseSymmetric mouseHandlerDrawCreaseSymmetric;

    public MouseHandlerCreaseSelect(DrawingWorker d) {
        super(d);
        mouseHandlerCreaseMove4p = new MouseHandlerCreaseMove4p(d);
        mouseHandlerCreaseCopy4p = new MouseHandlerCreaseCopy4p(d);
        mouseHandlerCreaseCopy = new MouseHandlerCreaseCopy(d);
        mouseHandlerCreaseMove = new MouseHandlerCreaseMove(d);
        mouseHandlerDrawCreaseSymmetric = new MouseHandlerDrawCreaseSymmetric(d);
    }

    @Override
    public MouseMode getMouseMode() {
        return MouseMode.CREASE_SELECT_19;
    }

    @Override
    public void mouseMoved(Point p0) {

    }

    //マウス操作(mouseMode==19  select　でボタンを押したとき)時の作業----------------------------------------------------
    public void mousePressed(Point p0) {
        System.out.println("19  select_");
        System.out.println("i_egaki_dankai=" + d.i_drawing_stage);

        Point p = new Point();

        if (d.i_drawing_stage == 0) {//i_select_modeを決める
            p.set(d.camera.TV2object(p0));
        }

        switch (d.i_select_mode) {
            case NORMAL_0:
                d.mPressed_A_box_select(p0);
                break;
            case MOVE_1:
                mouseHandlerCreaseMove.mousePressed(p0);//move
                break;
            case MOVE4P_2:
                mouseHandlerCreaseMove4p.mousePressed(p0);//move 2p2p
                break;
            case COPY_3:
                mouseHandlerCreaseCopy.mousePressed(p0);//copy
                break;
            case COPY4P_4:
                mouseHandlerCreaseCopy4p.mousePressed(p0);//copy 2p2p
                break;
            case MIRROR_5:
                mouseHandlerDrawCreaseSymmetric.mousePressed(p0);//鏡映
                break;
        }
    }

//20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20 20

    //マウス操作(mouseMode==19 select　でドラッグしたとき)を行う関数----------------------------------------------------
    public void mouseDragged(Point p0) {
        //mDragged_A_box_select( p0);
        switch (d.i_select_mode) {
            case NORMAL_0:
                d.mDragged_A_box_select(p0);
                break;
            case MOVE_1:
                mouseHandlerCreaseMove.mouseDragged(p0);//move
                break;
            case MOVE4P_2:
                mouseHandlerCreaseMove4p.mouseDragged(p0);//move 2p2p
                break;
            case COPY_3:
                mouseHandlerCreaseCopy.mouseDragged(p0);//copy
                break;
            case COPY4P_4:
                mouseHandlerCreaseCopy4p.mouseDragged(p0);//copy 2p2p
                break;
            case MIRROR_5:
                mouseHandlerDrawCreaseSymmetric.mouseDragged(p0);//鏡映
                break;
        }
    }

    //マウス操作(mouseMode==19 select　でボタンを離したとき)を行う関数----------------------------------------------------
    public void mouseReleased(Point p0) {
        switch (d.i_select_mode) {
            case NORMAL_0:
                mReleased_A_box_select(p0);
                break;
            case MOVE_1:
                mouseHandlerCreaseMove.mouseReleased(p0);//move
                break;
            case MOVE4P_2:
                mouseHandlerCreaseMove4p.mouseReleased(p0);//move 2p2p
                break;
            case COPY_3:
                mouseHandlerCreaseCopy.mouseReleased(p0);//copy
                break;
            case COPY4P_4:
                mouseHandlerCreaseCopy4p.mouseReleased(p0);//copy 2p2p
                break;
            case MIRROR_5:
                mouseHandlerDrawCreaseSymmetric.mouseReleased(p0);//鏡映
                break;
        }
    }

    public void mReleased_A_box_select(Point p0) {
        d.i_drawing_stage = 0;

        d.select(d.p19_1, p0);
        if (d.p19_1.distance(p0) <= 0.000001) {
            Point p = new Point();
            p.set(d.camera.TV2object(p0));
            if (d.foldLineSet.closestLineSegmentDistance(p) < d.selectionDistance) {//点pに最も近い線分の番号での、その距離を返す	public double mottomo_tikai_senbun_kyori(Ten p)
                d.foldLineSet.closestLineSegmentSearch(p).setSelected(2);
            }
        }
    }
}
