package oriedita.editor.action;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import oriedita.editor.canvas.CreasePattern_Worker;
import oriedita.editor.canvas.MouseMode;
import oriedita.editor.databinding.CanvasModel;
import oriedita.editor.databinding.InternalDivisionRatioModel;

import java.awt.event.ActionEvent;

@ApplicationScoped
@ActionHandler(ActionType.drawLineSegmentInternalDivisionRatioAction)
public class DrawLineSegmentInternalDivisionRatioAction extends AbstractOrieditaAction implements MouseModeAction {
    @Override
    public MouseMode getMouseMode() {
        return MouseMode.LINE_SEGMENT_RATIO_SET_28;
    }

    @Inject
    CanvasModel canvasModel;

    @Inject @Named("mainCreasePattern_Worker")
    CreasePattern_Worker mainCreasePatternWorker;

    @Inject
    public DrawLineSegmentInternalDivisionRatioAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        canvasModel.setMouseMode(MouseMode.LINE_SEGMENT_RATIO_SET_28);
        canvasModel.setMouseModeAfterColorSelection(MouseMode.LINE_SEGMENT_RATIO_SET_28);

        mainCreasePatternWorker.unselect_all(false);
    }
}
