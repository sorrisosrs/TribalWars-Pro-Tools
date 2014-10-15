package net.wesleynascimento.twpt.frames;

import com.littlebigberry.httpfiledownloader.FileDownloader;
import com.littlebigberry.httpfiledownloader.FileDownloaderDelegate;
import net.wesleynascimento.twpt.decorators.FrameDecorator;
import org.json.JSONFactory;
import net.wesleynascimento.twpt.components.ProgressBar;
import net.wesleynascimento.twpt.components.TWLabel;
import org.json.JSONObject;

import javax.security.auth.login.Configuration;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Wesley on 30/08/2014.
 */
public class UpdateFrame extends FrameDecorator implements FileDownloaderDelegate {

    private final static double currentVersion = 0.1000;
    private final static String packagePath = "https://raw.githubusercontent.com/sorrisosrs/TribalWars-Pro-Tools/master/package.json"; //Remote Package.json file, contains information about app version and update link

    private ProgressBar progressBar;
    private TWLabel progressLabel;

    private JSONObject remote; //Remote update Ffile

    public UpdateFrame(){
        super("Atualizador", 300, 100, false);
    }

    @Override
    public void createComponents() {
        progressBar = new ProgressBar();
        progressBar.setBounds(10, getHeight() / 2 - (5 / 2), getWidth() - 20, 5);
        container.add( progressBar );


        progressLabel = new TWLabel("Updater", 12);
        progressLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        progressLabel.setBounds(10, progressBar.getY() - 20, getWidth() - 20, 20);
        container.add( progressLabel );
    }
    public void start(){
        //Carrega as configurações,

        //Se configurado pra buscar atualização, então busca.
        //Se tiver atualização, atualiza.
        if ( checkForAppUpdates() ){
            doUpdate();
        }

        //Se configurado para abrir o WorldSelectionFrame, ent�o abre!

        //Done
    }

    public void loadLocalFiles(){
        //Cria a instancia static do Configuration e do WorldManager
    }

    public JSONObject loadRemoteFile() throws IOException {
        return JSONFactory.getJSON(packagePath);
    }

    public boolean checkForAppUpdates(){
        try {
            remote = loadRemoteFile();
        } catch (IOException e) {
            System.out.println("Can't find or open the package file.");
            return false;
        }

        if( remote.getDouble("version") > currentVersion ){
            return true;
        }
        else {
            return false;
        }
    }

    public void doUpdate(){
        String downloadPath = remote.getString("download_link");
    }

    public void checkForModulesUpdates(){

    }


    @Override
    public void didStartDownload(FileDownloader fileDownloader) {
        progressBar.reset();
    }

    @Override
    public void didProgressDownload(FileDownloader fileDownloader) {
        progressBar.changeProgress(Integer.valueOf(fileDownloader.getPercentComplete()));
    }

    @Override
    public void didFinishDownload(FileDownloader fileDownloader) {

    }

    @Override
    public void didFailDownload(FileDownloader fileDownloader) {

    }
}
