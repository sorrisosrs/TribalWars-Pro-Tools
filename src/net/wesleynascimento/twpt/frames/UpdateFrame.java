package net.wesleynascimento.twpt.frames;

import com.littlebigberry.httpfiledownloader.FileDownloader;
import com.littlebigberry.httpfiledownloader.FileDownloaderDelegate;
import net.wesleynascimento.twpt.Configuration;
import net.wesleynascimento.twpt.components.ProgressBar;
import net.wesleynascimento.twpt.components.TWLabel;
import net.wesleynascimento.twpt.decorators.FrameDecorator;
import net.wesleynascimento.twpt.factories.ConfigFactory;
import org.json.JSONFactory;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Wesley on 30/08/2014.
 */
public class UpdateFrame extends FrameDecorator implements FileDownloaderDelegate {

    private final static double currentVersion = 0.1001;
    private final static String packagePath = "https://raw.githubusercontent.com/sorrisosrs/TribalWars-Pro-Tools/master/package.json"; //Remote Package.json file, contains information about app version and update link
    private final static String TEMP_JAR_NAME = "twpt.jar.temp";

    private ProgressBar progressBar;
    private TWLabel progressLabel;

    private JSONObject remote; //Remote update Ffile

    public UpdateFrame() {
        super("Atualizador", 300, 100, false);
    }

    @Override
    public void createComponents() {
        progressBar = new ProgressBar();
        progressBar.setBounds(10, getHeight() / 2 - (5 / 2), getWidth() - 20, 5);
        container.add(progressBar);


        progressLabel = new TWLabel("Updater", 12);
        progressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressLabel.setBounds(10, progressBar.getY() - 20, getWidth() - 20, 20);
        container.add(progressLabel);
    }

    public void start() {
        //Carrega as configurações,
        progressBar.changeProgress(0.1);
        Configuration config = new ConfigFactory().getLoadedConfig();
        progressBar.changeProgress(0.15);

        //Se configurado pra buscar atualização, então busca.
        //Se tiver atualização, atualiza.
        progressBar.changeProgress(0.20);
        if (config.getConfig("check-updates", true) && checkForAppUpdates()) {
            progressBar.changeProgress(0.25);
            doUpdate();
        }
        else {
            openApp();
        }
    }

    public void openApp(){
        progressBar.changeProgress(1.0);
        Configuration config = new ConfigFactory().getLoadedConfig();

        //Se configurado para abrir o WorldSelectionFrame
        if (config.getConfig("default-world") == null) {
            new WorldSelectionFrame().setVisible(true);
        }
        //Abre o Main frame
        else {
            new TWPTFrame().setVisible(true);
        }
    }

    public void reOpenApp(){
        //Execute an .bat to delete the old file and rename the new file!
    }

    public void loadLocalFiles() {
        //Cria a instancia static do Configuration e do WorldManager
    }

    public JSONObject loadRemoteFile() throws IOException {
        return new JSONFactory().getJSON(packagePath);
    }

    public boolean checkForAppUpdates() {
        try {
            remote = loadRemoteFile();
        } catch (IOException e) {
            System.out.println("Can't find or open the package file.");
            return false;
        }

        if (remote.getDouble("version") > currentVersion) {
            return true;
        } else {
            return false;
        }
    }

    public void doUpdate() {
        String downloadPath = remote.getString("download_link");

        //File localFile = new File(new File(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile(), TEMP_JAR_NAME);

        //< know bug: can't fing or open the file...
        FileDownloader fileDownloader = new FileDownloader(this);
        fileDownloader.setUrl(downloadPath);
        fileDownloader.setLocalLocation( Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath() );
        fileDownloader.beginDownload();
    }

    public void checkForModulesUpdates() {

    }


    @Override
    public void didStartDownload(FileDownloader fileDownloader) {
    }

    @Override
    public void didProgressDownload(FileDownloader fileDownloader) {
        int downloadPercentage = Integer.valueOf(fileDownloader.getPercentComplete());
        progressBar.changeProgress( (100 * downloadPercentage) / 75);
    }

    @Override
    public void didFinishDownload(FileDownloader fileDownloader) {
        reOpenApp();
    }

    @Override
    public void didFailDownload(FileDownloader fileDownloader) {
        JOptionPane.showMessageDialog(this, "Erro ao tentar fazer download da atualização.\nO TWPT será iniciado normalmente.", "Erro!", JOptionPane.ERROR_MESSAGE);
        openApp();
    }
}
