package org.netbeans.ts.options;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import org.netbeans.modules.css.prep.sass.TypeScriptExecutable;
//import org.netbeans.modules.css.prep.util.FileUtils;
import org.openide.awt.HtmlBrowser;
import org.openide.awt.Mnemonics;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

public final class TypeScriptOptionsPanel extends JPanel {

    private static final long serialVersionUID = 268356546654654L;

    private static final Logger LOGGER = Logger.getLogger(TypeScriptOptionsPanel.class.getName());

    private final ChangeSupport changeSupport = new ChangeSupport(this);


    public TypeScriptOptionsPanel() {
        initComponents();
        init();
    }

    @NbBundle.Messages({
        "# {0} - long script name",
        "# {1} - short script name",
        "TypeScriptOptionsPanel.path.hint=Full path of TypeScript executable (typically {0} or {1}).",
    })
    private void init() {
        tscPathHintLabel.setText(Bundle.TypeScriptOptionsPanel_path_hint("tsc.cmd", "tsc"));

        // listeners
        tscPathTextField.getDocument().addDocumentListener(new DefaultDocumentListener());
        DefaultItemListener defaultItemListener = new DefaultItemListener();
        tscOutputOnErrorCheckBox.addItemListener(defaultItemListener);
        tscDebugCheckBox.addItemListener(defaultItemListener);
    }

    public String getTypeScriptPath() {
        return tscPathTextField.getText();
    }

    public void setTypeScriptPath(String path) {
        tscPathTextField.setText(path);
    }

    public boolean getTypeScriptOutputOnError() {
        return tscOutputOnErrorCheckBox.isSelected();
    }

    public void setTypeScriptOutputOnError(boolean outputOnError) {
        tscOutputOnErrorCheckBox.setSelected(outputOnError);
    }

    public boolean getTypeScriptDebug() {
        return tscDebugCheckBox.isSelected();
    }

    public void setTypeScriptDebug(boolean debug) {
        tscDebugCheckBox.setSelected(debug);
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    void fireChange() {
        changeSupport.fireChange();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tscPathLabel = new JLabel();
        tscPathTextField = new JTextField();
        tscPathBrowseButton = new JButton();
        tscPathSearchButton = new JButton();
        tscPathHintLabel = new JLabel();
        installTscLabel = new JLabel();
        tscOutputOnErrorCheckBox = new JCheckBox();
        tscDebugCheckBox = new JCheckBox();

        tscPathLabel.setLabelFor(tscPathTextField);
        Mnemonics.setLocalizedText(tscPathLabel, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.TypeScriptPathLabel.text")); // NOI18N

        Mnemonics.setLocalizedText(tscPathBrowseButton, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.tscPathBrowseButton.text")); // NOI18N
        tscPathBrowseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tscPathBrowseButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(tscPathSearchButton, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.tscPathSearchButton.text")); // NOI18N
        tscPathSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                tscPathSearchButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(tscPathHintLabel, "HINT"); // NOI18N

        Mnemonics.setLocalizedText(installTscLabel, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.installTypeScriptLabel.text")); // NOI18N
        installTscLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                installTscLabelMouseEntered(evt);
            }
            public void mousePressed(MouseEvent evt) {
                installTscLabelMousePressed(evt);
            }
        });

        Mnemonics.setLocalizedText(tscOutputOnErrorCheckBox, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.tscOutputOnErrorCheckBox.text")); // NOI18N

        Mnemonics.setLocalizedText(tscDebugCheckBox, NbBundle.getMessage(TypeScriptOptionsPanel.class, "TypeScriptOptionsPanel.tscDebugCheckBox.text")); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tscPathLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tscPathHintLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(installTscLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tscPathTextField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tscPathBrowseButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tscPathSearchButton))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tscOutputOnErrorCheckBox)
                    .addComponent(tscDebugCheckBox))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {tscPathBrowseButton, tscPathSearchButton});

        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tscPathLabel)
                    .addComponent(tscPathBrowseButton)
                    .addComponent(tscPathSearchButton)
                    .addComponent(tscPathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tscPathHintLabel)
                    .addComponent(installTscLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tscOutputOnErrorCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tscDebugCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("TypeScriptOptionsPanel.browse.title=Select TypeScript")
    private void tscPathBrowseButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tscPathBrowseButtonActionPerformed
        File file = new FileChooserBuilder(TypeScriptOptionsPanel.class)
                .setFilesOnly(true)
                .setTitle(Bundle.TypeScriptOptionsPanel_browse_title())
                .showOpenDialog();
        if (file != null) {
            tscPathTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_tscPathBrowseButtonActionPerformed

    @NbBundle.Messages("TypeScriptOptionsPanel.executable.notFound=No TypeScript executable found.")
    private void tscPathSearchButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_tscPathSearchButtonActionPerformed
        List<String> tscPaths = FileUtils.findFileOnUsersPath("tsc.cmd", "tsc");
        if (tscPaths.isEmpty()) {
            StatusDisplayer.getDefault().setStatusText(Bundle.TypeScriptOptionsPanel_executable_notFound());
        } else {
            tscPathTextField.setText(tscPaths.get(0));
        }
    }//GEN-LAST:event_tscPathSearchButtonActionPerformed

    private void installTscLabelMouseEntered(MouseEvent evt) {//GEN-FIRST:event_installTscLabelMouseEntered
        evt.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_installTscLabelMouseEntered

    private void installTscLabelMousePressed(MouseEvent evt) {//GEN-FIRST:event_installTscLabelMousePressed
        try {
            URL url = new URL("https://www.npmjs.com/package/typescript"); // NOI18N
            HtmlBrowser.URLDisplayer.getDefault().showURL(url);
        } catch (MalformedURLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_installTscLabelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel installTscLabel;
    private JCheckBox tscDebugCheckBox;
    private JCheckBox tscOutputOnErrorCheckBox;
    private JButton tscPathBrowseButton;
    private JLabel tscPathHintLabel;
    private JLabel tscPathLabel;
    private JButton tscPathSearchButton;
    private JTextField tscPathTextField;
    // End of variables declaration//GEN-END:variables

    //~ Inner classes

    private final class DefaultDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            processUpdate();
        }

        private void processUpdate() {
            fireChange();
        }

    }

    private final class DefaultItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            fireChange();
        }

    }

}
