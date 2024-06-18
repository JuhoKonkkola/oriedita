package oriedita.editor.action;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {
    lineWidthDecreaseAction("lineWidthDecreaseAction"),
    newAction("newAction"),
    openAction("openAction"),
    saveAction("saveAction"),
    saveAsAction("saveAsAction"),
    exitAction("exitAction"),
    IMPORT("importAction"),
    IMPORT_ADD("inputDataAction"),
    drawCreaseFreeAction("drawCreaseFreeAction"),
    lineWidthIncreaseAction("lineWidthIncreaseAction"),
    pointSizeDecreaseAction("pointSizeDecreaseAction"),
    pointSizeIncreaseAction("pointSizeIncreaseAction"),
    antiAliasToggleAction("antiAliasToggleAction"),
    lineStyleChangeAction("lineStyleChangeAction"),
    colRedAction("colRedAction"),
    colBlueAction("colBlueAction"),
    colBlackAction("colBlackAction"),
    colCyanAction("colCyanAction"),
    toMountainAction("toMountainAction"),
    toValleyAction("toValleyAction"),
    toEdgeAction("toEdgeAction"),
    toAuxAction("toAuxAction"),
    zen_yama_tani_henkanAction("zen_yama_tani_henkanAction"),
    senbun_henkan2Action("senbun_henkan2Action"),
    senbun_henkanAction("senbun_henkanAction"),
    in_L_col_changeAction("in_L_col_changeAction"),
    on_L_col_changeAction("on_L_col_changeAction"),
    vertexAddAction("vertexAddAction"),
    vertexDeleteAction("vertexDeleteAction"),
    v_del_ccAction("v_del_ccAction"),
    v_del_allAction("v_del_allAction"),
    v_del_all_ccAction("v_del_all_ccAction"),
    drawTwoColoredCpAction("drawTwoColoredCpAction"),
    suitei_01Action("suitei_01Action"),
    koteimen_siteiAction("koteimen_siteiAction"),
    suitei_02Action("suitei_02Action"),
    suitei_03Action("suitei_03Action"),
    coloredXRayDecreaseAction("coloredXRayDecreaseAction"),
    coloredXRayIncreaseAction("coloredXRayIncreaseAction"),
    perpendicularDrawAction("perpendicularDrawAction"),
    lineSegmentDivisionSetAction("lineSegmentDivisionSetAction"),
    senbun_b_nyuryokuAction("senbun_b_nyuryokuAction"),
    all_s_step_to_orisenAction("all_s_step_to_orisenAction"),
    voronoiAction("voronoiAction"),
    parallelDrawAction("parallelDrawAction"),
    fishBoneDrawAction("fishBoneDrawAction"),
    setParallelDrawWidthAction("setParallelDrawWidthAction"),
    doubleSymmetricDrawAction("doubleSymmetricDrawAction"),
    makeFlatFoldableAction("makeFlatFoldableAction"),
    continuousSymmetricDrawAction("continuousSymmetricDrawAction"),
    symmetricDrawAction("symmetricDrawAction"),
    angleBisectorAction("angleBisectorAction"),
    lengthenCrease2Action("lengthenCrease2Action"),
    lengthenCreaseAction("lengthenCreaseAction"),
    drawCreaseRestrictedAction("drawCreaseRestrictedAction"),
    rabbitEarAction("rabbitEarAction"),
    foldableLineDrawAction("foldableLineDrawAction"),
    foldableLinePlusGridInputAction("foldableLinePlusGridInputAction"),
    selectAction("selectAction"),
    selectAllAction("selectAllAction"),
    moveAction("moveAction"),
    move2p2pAction("move2p2pAction"),
    reflectAction("reflectAction"),
    unselectAction("unselectAction"),
    unselectAllAction("unselectAllAction"),
    copyAction("copyAction"),
    copy2p2pAction("copy2p2pAction"),
    deleteSelectedLineSegmentAction("deleteSelectedLineSegmentAction"),
    gridSizeDecreaseAction("gridSizeDecreaseAction"),
    gridSizeSetAction("gridSizeSetAction"),
    gridSizeIncreaseAction("gridSizeIncreaseAction"),
    gridColorAction("gridColorAction"),
    gridLineWidthDecreaseAction("gridLineWidthDecreaseAction"),
    gridLineWidthIncreaseAction("gridLineWidthIncreaseAction"),
    changeGridStateAction("changeGridStateAction"),
    moveIntervalGridVerticalAction("moveIntervalGridVerticalAction"),
    setIntervalGridSizeAction("setIntervalGridSizeAction"),
    moveIntervalGridHorizontalAction("moveIntervalGridHorizontalAction"),
    intervalGridColorAction("intervalGridColorAction"),
    lineSegmentDeleteAction("lineSegmentDeleteAction"),
    edgeLineSegmentDeleteAction("edgeLineSegmentDeleteAction"),
    auxLiveLineSegmentDeleteAction("auxLiveLineSegmentDeleteAction"),
    trimBranchesAction("trimBranchesAction"),
    setGridParametersAction("setGridParametersAction"),
    gridConfigureResetAction("gridConfigureResetAction"),
    operationFrameSelectAction("operationFrameSelectAction"),
    moveCreasePatternAction("moveCreasePatternAction"),
    creasePatternZoomOutAction("creasePatternZoomOutAction"),
    creasePatternZoomInAction("creasePatternZoomInAction"),
    rotateAnticlockwiseAction("rotateAnticlockwiseAction"),
    rotateClockwiseAction("rotateClockwiseAction"),
    senbun_yoke_henkanAction("senbun_yoke_henkanAction"),
    lineSegmentInternalDivisionRatioSetAction("lineSegmentInternalDivisionRatioSetAction"),
    drawLineSegmentInternalDivisionRatioAction("drawLineSegmentInternalDivisionRatioAction"),
    scaleFactorSetAction("scaleFactorSetAction"),
    rotationSetAction("rotationSetAction"),
    transparentAction("transparentAction"),
    backgroundTrimAction("backgroundTrimAction"),
    readBackgroundAction("readBackgroundAction"),
    backgroundToggleAction("backgroundToggleAction"),
    backgroundSetPositionAction("backgroundSetPositionAction"),
    backgroundLockAction("backgroundLockAction"),
    mouseSettingsAction("mouseSettingsAction"),
    foldAction("foldAction"),
    trashAction("foldedFigureTrashAction"),
    anotherSolutionAction("anotherSolutionAction"),
    haltAction("haltAction"),
    resetAction("resetAction"),
    flipAction("foldedFigureFlipAction"),
    scaleAction("scaleAction"),
    duplicateFoldedModelAction("duplicateFoldedModelAction"),
    frontColorAction("frontColorAction"),
    As100Action("As100Action"),
    lineColorAction("lineColorAction"),
    backColorAction("backColorAction"),
    oriagari_sousaAction("oriagari_sousaAction"),
    oriagari_sousa_2Action("oriagari_sousa_2Action"),
    deg2Action("deg2Action"),
    deg3Action("deg3Action"),
    deg4Action("deg4Action"),
    ad_fncAction("ad_fncAction"),
    selectAnd3ClickAction("selectAnd3ClickAction"),
    angleSystemADecreaseAction("angleSystemADecreaseAction"),
    angleSystemAAction("angleSystemAAction"),
    angleSystemAIncreaseAction("angleSystemAIncreaseAction"),
    angleSystemBDecreaseAction("angleSystemBDecreaseAction"),
    angleSystemBAction("angleSystemBAction"),
    angleSystemBIncreaseAction("angleSystemBIncreaseAction"),
    cAMVAction("cAMVAction"),
    circleDrawFreeAction("circleDrawFreeAction"),
    circleDrawAction("circleDrawAction"),
    circleDrawSeparateAction("circleDrawSeparateAction"),
    circleDrawConcentricAction("circleDrawConcentricAction"),
    circleDrawConcentricSelectAction("circleDrawConcentricSelectAction"),
    circleDrawTwoConcentricAction("circleDrawTwoConcentricAction"),
    circleDrawTangentLineAction("circleDrawTangentLineAction"),
    circleDrawThreePointAction("circleDrawThreePointAction"),
    circleDrawInvertedAction("circleDrawInvertedAction"),
    ckOAction("ckOAction"),
    ckTAction("ckTAction"),
    fxOAction("fxOAction"),
    fxTAction("fxTAction"),
    ck4_colorDecreaseAction("ck4_colorDecreaseAction"),
    ck4_colorIncreaseAction("ck4_colorIncreaseAction"),
    colOrangeAction("colOrangeAction"),
    colYellowAction("colYellowAction"),
    del_l_typeAction("del_l_typeAction"),
    del_lAction("del_lAction"),
    del_l_XAction("del_l_XAction"),
    deg1Action("deg1Action"),
    displayCommentsAction("displayCommentsAction"),
    displayCpLinesAction("displayCpLinesAction"),
    displayAuxLinesAction("displayAuxLinesAction"),
    displayLiveAuxLinesAction("displayLiveAuxLinesAction"),
    displayStandardFaceMarksAction("displayStandardFaceMarksAction"),
    drawDiagonalGridlinesAction("drawDiagonalGridlinesAction"),
    foldedFigureMoveAction("foldedFigureMoveAction"),
    foldedFigureSizeIncreaseAction("foldedFigureSizeIncreaseAction"),
    foldedFigureSizeDecreaseAction("foldedFigureSizeDecreaseAction"),
    foldedFigureSizeSetAction("foldedFigureSizeSetAction"),
    foldedFigureRotateClockwiseAction("foldedFigureRotateClockwiseAction"),
    foldedFigureRotateAntiClockwiseAction("foldedFigureRotateAntiClockwiseAction"),
    foldedFigureToggleAntiAliasAction("foldedFigureToggleAntiAliasAction"),
    foldedFigureToggleShadowAction("foldedFigureToggleShadowAction"),
    goToFoldedFigureAction("goToFoldedFigureAction"),
    h_senhaba_sageAction("h_senhaba_sageAction"),
    h_senhaba_ageAction("h_senhaba_ageAction"),
    h_senbun_nyuryokuAction("h_senbun_nyuryokuAction"),
    h_senbun_sakujyoAction("h_senbun_sakujyoAction"),
    h_undoAction("h_undoAction"),
    h_redoAction("h_redoAction"),
    l1Action("l1Action"),
    l2Action("l2Action"),
    o_F_checkAction("o_F_checkAction"),
    pointOffsetAction("pointOffsetAction"),
    polygonSizeSetAction("polygonSizeSetAction"),
    replace_lineAction("replace_lineAction"),
    regularPolygonAction("regularPolygonAction"),
    select_polygonAction("select_polygonAction"),
    select_lXAction("select_lXAction"),
    sen_tokutyuu_color_henkouAction("sen_tokutyuu_color_henkouAction"),
    textAction("textAction"),
    toggleHelpAction("toggleHelpAction"),
    unselect_polygonAction("unselect_polygonAction"),
    unselect_lXAction("unselect_lXAction"),
    a1Action("a1Action"),
    a2Action("a2Action"),
    a3Action("a3Action"),
    c_colAction("c_colAction"),
    restrictedAngleABCSetAction("restrictedAngleABCSetAction"),
    restrictedAngleSetDEFAction("restrictedAngleSetDEFAction"),
    addColorConstraintAction("addColorConstraintAction"),
    axiom5Action("axiom5Action"),
    axiom7Action("axiom7Action"),
    switchReplaceAction("switchReplaceAction");


    static final Map<String, ActionType> actionMap;

    static {
        actionMap = new HashMap<>();
        for (ActionType type : values()) {
            actionMap.put(type.action(), type);
        }
    }

    private final String action;

    ActionType(String action) {
        this.action = action;
    }

    public static ActionType fromAction(String action) {
        if (actionMap.containsKey(action)) {
            return actionMap.get(action);
        }

        return null;
    }

    public String action() {
        return action;
    }
}
