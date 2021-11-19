package origami_editor.editor.component;

import origami_editor.editor.databinding.FoldedFigureModel;
import origami.crease_pattern.OritaCalc;
import origami_editor.editor.databinding.MeasuresModel;
import origami_editor.editor.service.ButtonService;

import javax.swing.*;
import java.awt.*;

public class FoldedFigureRotate extends JPanel {
    private JButton foldedFigureRotateAntiClockwiseButton;
    private JPanel panel1;
    private JTextField foldedFigureRotateTextField;
    private JButton foldedFigureRotateClockwiseButton;
    private JButton foldedFigureRotateSetButton;

    public FoldedFigureRotate(ButtonService buttonService, FoldedFigureModel foldedFigureModel, MeasuresModel measuresModel) {
        add($$$getRootComponent$$$());

        buttonService.registerButton(foldedFigureRotateAntiClockwiseButton, "foldedFigureRotateAntiClockwiseAction");
        buttonService.registerButton(foldedFigureRotateSetButton, "foldedFigureRotateSetAction");
        buttonService.registerButton(foldedFigureRotateClockwiseButton, "foldedFigureRotateClockwiseAction");

        foldedFigureRotateAntiClockwiseButton.addActionListener(e -> foldedFigureModel.setRotation(OritaCalc.angle_between_m180_180(foldedFigureModel.getRotation() + 11.25)));
        foldedFigureRotateSetButton.addActionListener(e -> foldedFigureModel.setRotation(OritaCalc.angle_between_m180_180(measuresModel.string2double(foldedFigureRotateTextField.getText(), foldedFigureModel.getRotation()))));
        foldedFigureRotateClockwiseButton.addActionListener(e -> foldedFigureModel.setRotation(OritaCalc.angle_between_m180_180(foldedFigureModel.getRotation() - 11.25)));
        foldedFigureRotateTextField.addActionListener(e -> foldedFigureRotateSetButton.doClick());
    }

    public void setText(String text) {
        foldedFigureRotateTextField.setText(text);
        foldedFigureRotateTextField.setCaretPosition(0);
    }

    public String getText() {
        return foldedFigureRotateTextField.getText();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        foldedFigureRotateAntiClockwiseButton = new JButton();
        foldedFigureRotateAntiClockwiseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/oriagari_p_kaiten.png")));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(foldedFigureRotateAntiClockwiseButton, gbc);
        foldedFigureRotateTextField = new JTextField();
        foldedFigureRotateTextField.setColumns(2);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(foldedFigureRotateTextField, gbc);
        foldedFigureRotateSetButton = new JButton();
        foldedFigureRotateSetButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(foldedFigureRotateSetButton, gbc);
        foldedFigureRotateClockwiseButton = new JButton();
        foldedFigureRotateClockwiseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/oriagari_m_kaiten.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(foldedFigureRotateClockwiseButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
