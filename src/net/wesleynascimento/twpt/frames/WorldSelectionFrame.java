package net.wesleynascimento.twpt.frames;

import net.wesleynascimento.twpt.components.*;
import net.wesleynascimento.twpt.decorators.FrameDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by Wesley on 30/08/2014.
 */
public class WorldSelectionFrame extends FrameDecorator {

    public WorldSelectionFrame(){
        super("Seleção de Mundo", 300, 175, true);
    }

    private TWText worldName;
    private TWText serverName;
    private TWButtonSimple testButton;
    private TWButtonSimple saveButton;
    private TWButton startButton;
    private ProgressBar progressBar;

    @Override
    public void createComponents() {
        TWLabel label1 = new TWLabel("Mundo");
        label1.setBounds(10, ySpacing + 10, 40, 30);

        worldName = new TWText();
        worldName.setForeground(Color.black );
        worldName.setPlaceholder("br62");
        worldName.setBounds(10, ySpacing + 2 + 30, 40, 30);

        TWLabel label2 = new TWLabel("Servidor");
        label2.setBounds( 40 + 20, ySpacing + 10, getWidth() - 70, 30);

        serverName = new TWText();
        serverName.setForeground(Color.black );
        serverName.setPlaceholder("tribalwars.com.br");
        serverName.setBounds( 40 + 20, ySpacing + 2 + 30, getWidth() - 70, 30);

        progressBar = new ProgressBar();
        progressBar.setBounds( 10, ySpacing + 62 + 10, getWidth() - 110 - 30, 30);
        progressBar.setVisible( false );

        testButton = new TWButtonSimple("Testar Conexao.", this, "test_server_connection");
        testButton.setBounds(getWidth() - 110 - 10, ySpacing + 62 + 10, 110, 30);

        saveButton = new TWButtonSimple("Salvar como padrão", this, "save_world_information");
        saveButton.setBounds(getWidth() / 2 - 130 - 5, ySpacing + 102 + 10, 130, 30);
        saveButton.setEnabled( false );

        startButton = new TWButton("Iniciar", this, "open_main_frame");
        startButton.setBounds(getWidth() / 2 + 5, ySpacing + 102 + 10, 110, 30);
        startButton.setEnabled( false );

        container.add(label1);
        container.add( worldName );
        container.add(label2);
        container.add( serverName );
        container.add( progressBar );
        container.add(testButton);
        container.add(saveButton);
        container.add( startButton );
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed( event );
        switch ( event.getActionCommand() ){
            case "test_server_connection":
                testConnection();
                break;
            case "save_world_information":
                saveAsDefault();
                break;
            case "open_main_frame":
                break;
        }
    }

    public void saveAsDefault(){

    }

    public void testConnection(){
        if( worldName.getText().equals("") || serverName.getText().equals("") ){
            failCleanUp();
            JOptionPane.showMessageDialog(this, "Por favor, preencha os campos de Mundo e Servidor!", "Erro!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        progressBar.setVisible( true );
        testButton.setEnabled( false );
        worldName.setEnabled( false );
        serverName.setEnabled( false );
        startButton.setEnabled( false );
        saveButton.setEnabled( false );
        progressBar.changeProgress(0);


    }

    public void failCleanUp(){
        progressBar.setVisible( false );
        testButton.setEnabled( true );
        worldName.setEnabled( true );
        serverName.setEnabled( true );
        startButton.setEnabled( false );
        saveButton.setEnabled( false );
    }

    public void successCleanUp(){
        progressBar.setVisible( false );
        testButton.setEnabled( true );
        worldName.setEnabled( true );
        serverName.setEnabled( true );
        startButton.setEnabled( true );
        saveButton.setEnabled( true );
    }
}
