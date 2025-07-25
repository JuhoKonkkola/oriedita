package oriedita.editor.handler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import oriedita.editor.canvas.MouseMode;
import oriedita.editor.databinding.CanvasModel;
import origami.Epsilon;
import origami.crease_pattern.CustomLineTypes;
import origami.crease_pattern.element.LineColor;
import origami.crease_pattern.element.LineSegment;
import origami.crease_pattern.element.Point;

import java.util.EnumSet;

@ApplicationScoped
@Handles(MouseMode.DELETE_LINE_TYPE_SELECT_73)
public class MouseHandlerDeleteTypeSelect extends BaseMouseHandlerBoxSelect {

    private final CanvasModel canvasModel;

    @Inject
    public MouseHandlerDeleteTypeSelect(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
    }

    @Override
    public EnumSet<MouseHandlerSettingGroup> getSettings() {
        return EnumSet.of(MouseHandlerSettingGroup.ERASER_COLOR);
    }

    public void mouseReleased(Point p0){
        super.mouseReleased(p0);
        d.getLineStep().clear();

        Point p = d.getCamera().TV2object(p0);

        CustomLineTypes del = canvasModel.getDelLineType();

        if (selectionStart.distance(p0) > Epsilon.UNKNOWN_1EN6) {//現状では赤を赤に変えたときもUNDO用に記録されてしまう20161218
            if (d.insideToDeleteType(selectionStart, p0, del)) {
                d.record();
            }
        } else {//現状では赤を赤に変えたときもUNDO用に記録されてしまう20161218
            if (d.getFoldLineSet().closestLineSegmentDistance(p) < d.getSelectionDistance()) {//点pに最も近い線分の番号での、その距離を返す	public double closestLineSegmentDistance(Ten p)
                LineSegment s = d.getFoldLineSet().closestLineSegmentSearch(p);

                switch (del){
                    case ANY:
                        d.getFoldLineSet().deleteLine(s);
                        d.record();
                        break;
                    case EDGE:
                        if (s.getColor() == LineColor.BLACK_0) {
                            d.getFoldLineSet().deleteLine(s);
                            d.record();
                        }
                        break;
                    case MANDV:
                        if (s.getColor() == LineColor.RED_1 || s.getColor() == LineColor.BLUE_2) {
                            d.getFoldLineSet().deleteLine(s);
                            d.record();
                        }
                        break;
                    case MOUNTAIN:
                    case VALLEY:
                    case AUX:
                        if (s.getColor() == LineColor.fromNumber(del.getNumber() - 1)) {
                            d.getFoldLineSet().deleteLine(s);
                            d.record();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
