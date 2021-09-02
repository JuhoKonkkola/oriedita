package origami_editor.editor;

import origami_editor.editor.component.ColorIcon;
import origami_editor.record.string_op.StringOp;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GridConfigureDialog extends JDialog {
    private final App app;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton gridSizeDecreaseButton;
    private JTextField gridSizeTextField;
    private JButton gridSizeSetButton;
    private JButton gridSizeIncreaseButton;
    private JButton gridColorButton;
    private JButton gridLineWidthDecreaseButton;
    private JButton gridLineWidthIncreaseButton;
    private JButton i_kitei_jyoutaiButton;
    private JButton memori_tate_idouButton;
    private JTextField intervalGridSizeTextField;
    private JButton memori_kankaku_syutokuButton;
    private JButton memori_yoko_idouButton;
    private JButton intervalGridColorButton;
    private JTextField gridXATextField;
    private JTextField gridXBTextField;
    private JTextField gridXCTextField;
    private JTextField gridYATextField;
    private JTextField gridYBTextField;
    private JTextField gridYCTextField;
    private JTextField gridAngleTextField;
    private JButton setGridParametersButton;
    private JButton resetButton;

    public GridConfigureDialog(App app) {
        super(app, "Configure Grid");
        this.app = app;
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        GridConfiguration gridConfiguration = app.gridConfiguration;

        gridSizeDecreaseButton.addActionListener(e -> {
            app.setHelp("kitei2");

            int gridSize = gridConfiguration.getGridSize();

            gridSize = gridSize / 2;
            if (gridSize < 1) {
                gridSize = 1;
            }

            gridConfiguration.setGridSize(gridSize);

            app.updateGrid();
            app.repaintCanvas();
        });
        gridSizeSetButton.addActionListener(e -> {
            app.setHelp("syutoku");

            getData(gridConfiguration);

            app.updateGrid();
            app.repaintCanvas();
        });
        gridSizeIncreaseButton.addActionListener(e -> {
            app.setHelp("kitei");

            gridConfiguration.setGridSize(gridConfiguration.getGridSize() * 2);

            app.updateGrid();

            //ボタンの色変え(ここまで)
            app.repaintCanvas();
        });
        gridColorButton.addActionListener(e -> {
            app.setHelp("kousi_color");
            app.mouseDraggedValid = false;
            app.mouseReleasedValid = false;

            //以下にやりたいことを書く
            Color color = JColorChooser.showDialog(null, "Col", new Color(230, 230, 230));
            if (color != null) {
                gridConfiguration.setGridColor(color);

                app.updateGrid();
            }
            //以上でやりたいことは書き終わり

            app.repaintCanvas();
        });
        gridLineWidthDecreaseButton.addActionListener(e -> {
            gridConfiguration.decreaseGridLineWidth();
            app.updateGrid();

            app.setHelp("kousi_senhaba_sage");
            app.repaintCanvas();
        });
        gridLineWidthIncreaseButton.addActionListener(e -> {
            gridConfiguration.increaseGridLineWidth();
            app.updateGrid();

            app.setHelp("kousi_senhaba_age");
            app.repaintCanvas();
        });
        i_kitei_jyoutaiButton.addActionListener(e -> {
            app.setHelp("i_kitei_jyoutai");

            gridConfiguration.advanceBaseState();
            app.updateGrid();

            app.repaintCanvas();
        });
        memori_tate_idouButton.addActionListener(e -> {
            app.setHelp("memori_tate_idou");

            gridConfiguration.changeHorizontalScalePosition();
            app.updateGrid();

            app.repaintCanvas();
        });
        memori_kankaku_syutokuButton.addActionListener(e -> {
            app.setHelp("memori_kankaku_syutoku");

            getData(gridConfiguration);

            app.updateGrid();
        });
        memori_yoko_idouButton.addActionListener(e -> {
            app.setHelp("memori_yoko_idou");

            gridConfiguration.changeVerticalScalePosition();

            app.updateGrid();
        });
        intervalGridColorButton.addActionListener(e -> {
            app.setHelp("kousi_memori_color");
            app.mouseDraggedValid = false;
            app.mouseReleasedValid = false;

            //以下にやりたいことを書く
            Color color = JColorChooser.showDialog(null, "Col", new Color(180, 200, 180));
            if (color != null) {
                gridConfiguration.setGridScaleColor(color);
                app.updateGrid();
            }
            //以上でやりたいことは書き終わり

            app.repaintCanvas();
        });
        setGridParametersButton.addActionListener(e -> {
            app.setHelp("kousi_syutoku");

            getData(gridConfiguration);
            app.updateGrid();

            app.repaintCanvas();
        });
        resetButton.addActionListener(e -> {
            gridConfiguration.reset();
            app.updateGrid();
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
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
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        contentPane.add(panel1, BorderLayout.CENTER);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        buttonOK = new JButton();
        buttonOK.setText("Close");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(buttonOK, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel2.add(spacer2, gbc);
        resetButton = new JButton();
        resetButton.setText("Reset");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(resetButton, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel3, gbc);
        panel3.setBorder(BorderFactory.createTitledBorder(null, "Interval Grid", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        memori_tate_idouButton = new JButton();
        memori_tate_idouButton.setIcon(new ImageIcon(getClass().getResource("/ppp/memori_tate_idou.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(memori_tate_idouButton, gbc);
        intervalGridSizeTextField = new JTextField();
        intervalGridSizeTextField.setColumns(2);
        intervalGridSizeTextField.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(intervalGridSizeTextField, gbc);
        memori_kankaku_syutokuButton = new JButton();
        memori_kankaku_syutokuButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(memori_kankaku_syutokuButton, gbc);
        memori_yoko_idouButton = new JButton();
        memori_yoko_idouButton.setIcon(new ImageIcon(getClass().getResource("/ppp/memori_yoko_idou.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(memori_yoko_idouButton, gbc);
        intervalGridColorButton = new JButton();
        intervalGridColorButton.setText("Color");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel3.add(intervalGridColorButton, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel4, gbc);
        panel4.setBorder(BorderFactory.createTitledBorder(null, "Line Width", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        gridLineWidthDecreaseButton = new JButton();
        gridLineWidthDecreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/kousi_senhaba_sage.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(gridLineWidthDecreaseButton, gbc);
        gridLineWidthIncreaseButton = new JButton();
        gridLineWidthIncreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/kousi_senhaba_age.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(gridLineWidthIncreaseButton, gbc);
        i_kitei_jyoutaiButton = new JButton();
        i_kitei_jyoutaiButton.setIcon(new ImageIcon(getClass().getResource("/ppp/i_kitei_jyoutai.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel4.add(i_kitei_jyoutaiButton, gbc);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel5, gbc);
        panel5.setBorder(BorderFactory.createTitledBorder(null, "Grid Size", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        gridSizeDecreaseButton = new JButton();
        gridSizeDecreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/kitei2.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(gridSizeDecreaseButton, gbc);
        gridSizeTextField = new JTextField();
        gridSizeTextField.setColumns(2);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(gridSizeTextField, gbc);
        gridSizeSetButton = new JButton();
        gridSizeSetButton.setText("S");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(gridSizeSetButton, gbc);
        gridSizeIncreaseButton = new JButton();
        gridSizeIncreaseButton.setIcon(new ImageIcon(getClass().getResource("/ppp/kitei.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(gridSizeIncreaseButton, gbc);
        gridColorButton = new JButton();
        gridColorButton.setText("Color");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel5.add(gridColorButton, gbc);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel6, gbc);
        panel6.setBorder(BorderFactory.createTitledBorder(null, "Properties", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        gridXATextField = new JTextField();
        gridXATextField.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel6.add(gridXATextField, gbc);
        final JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(getClass().getResource("/ppp/plus_min.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel6.add(label1, gbc);
        gridXBTextField = new JTextField();
        gridXBTextField.setText("1.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel6.add(gridXBTextField, gbc);
        final JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon(getClass().getResource("/ppp/root_min.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel6.add(label2, gbc);
        gridXCTextField = new JTextField();
        gridXCTextField.setText("1.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel6.add(gridXCTextField, gbc);
        gridYATextField = new JTextField();
        gridYATextField.setText("0.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel6.add(gridYATextField, gbc);
        gridYBTextField = new JTextField();
        gridYBTextField.setText("1.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel6.add(gridYBTextField, gbc);
        gridYCTextField = new JTextField();
        gridYCTextField.setText("1.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        panel6.add(gridYCTextField, gbc);
        final JLabel label3 = new JLabel();
        label3.setIcon(new ImageIcon(getClass().getResource("/ppp/root_min.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        panel6.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setIcon(new ImageIcon(getClass().getResource("/ppp/plus_min.png")));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel6.add(label4, gbc);
        final JPanel panel7 = new JPanel();
        panel7.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel7, gbc);
        panel7.setBorder(BorderFactory.createTitledBorder(null, "Grid Angle", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        gridAngleTextField = new JTextField();
        gridAngleTextField.setHorizontalAlignment(11);
        gridAngleTextField.setText("90.0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel7.add(gridAngleTextField, gbc);
        setGridParametersButton = new JButton();
        setGridParametersButton.setText("Set");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel7.add(setGridParametersButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    public void setData(GridConfiguration data) {
        intervalGridSizeTextField.setText(String.valueOf(data.getIntervalGridSize()));
        gridSizeTextField.setText(String.valueOf(data.getGridSize()));
        gridXATextField.setText(String.valueOf(data.getGridXA()));
        gridXBTextField.setText(String.valueOf(data.getGridXB()));
        gridXCTextField.setText(String.valueOf(data.getGridXC()));
        gridYATextField.setText(String.valueOf(data.getGridYA()));
        gridYBTextField.setText(String.valueOf(data.getGridYB()));
        gridYCTextField.setText(String.valueOf(data.getGridYC()));
        gridAngleTextField.setText(String.valueOf(data.getGridAngle()));

        gridSizeDecreaseButton.setEnabled(data.getGridSize() != 1);
        gridLineWidthDecreaseButton.setEnabled(data.getGridLineWidth() != 1);

        gridColorButton.setIcon(new ColorIcon(data.getGridColor()));
        intervalGridColorButton.setIcon(new ColorIcon(data.getGridScaleColor()));
    }

    public void getData(GridConfiguration data) {
        data.setIntervalGridSize(StringOp.String2int(intervalGridSizeTextField.getText(), data.getIntervalGridSize()));
        data.setGridSize(StringOp.String2int(gridSizeTextField.getText(), data.getGridSize()));
        data.setGridXA(app.String2double(gridXATextField.getText(), data.getGridXA()));
        data.setGridXB(app.String2double(gridXBTextField.getText(), data.getGridXB()));
        data.setGridXC(app.String2double(gridXCTextField.getText(), data.getGridXC()));
        data.setGridYA(app.String2double(gridYATextField.getText(), data.getGridYA()));
        data.setGridYB(app.String2double(gridYBTextField.getText(), data.getGridYB()));
        data.setGridYC(app.String2double(gridYCTextField.getText(), data.getGridYC()));
        data.setGridAngle(app.String2double(gridAngleTextField.getText(), data.getGridAngle()));
    }

//    public boolean isModified(GridConfiguration data) {
//        if (intervalGridSizeTextField.getText() != null ? !intervalGridSizeTextField.getText().equals(data.getIntervalGridSize()) : data.getIntervalGridSize() != null)
//            return true;
//        if (gridSizeTextField.getText() != null ? !gridSizeTextField.getText().equals(data.getGridSize()) : data.getGridSize() != null)
//            return true;
//        if (gridXATextField.getText() != null ? !gridXATextField.getText().equals(data.getGridXA()) : data.getGridXA() != null)
//            return true;
//        if (gridXBTextField.getText() != null ? !gridXBTextField.getText().equals(data.getGridXB()) : data.getGridXB() != null)
//            return true;
//        if (gridXCTextField.getText() != null ? !gridXCTextField.getText().equals(data.getGridXC()) : data.getGridXC() != null)
//            return true;
//        if (gridYATextField.getText() != null ? !gridYATextField.getText().equals(data.getGridYA()) : data.getGridYA() != null)
//            return true;
//        if (gridYBTextField.getText() != null ? !gridYBTextField.getText().equals(data.getGridYB()) : data.getGridYB() != null)
//            return true;
//        if (gridYCTextField.getText() != null ? !gridYCTextField.getText().equals(data.getGridYC()) : data.getGridYC() != null)
//            return true;
//        if (gridAngleTextField.getText() != null ? !gridAngleTextField.getText().equals(data.getGridAngle()) : data.getGridAngle() != null)
//            return true;
//        return false;
//    }
}
