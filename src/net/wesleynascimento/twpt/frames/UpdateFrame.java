package net.wesleynascimento.twpt.frames;

import com.littlebigberry.httpfiledownloader.FileDownloader;
import com.littlebigberry.httpfiledownloader.FileDownloaderDelegate;
import net.wesleynascimento.twpt.decorators.FrameDecorator;
import org.json.JSONFactory;
import net.wesleynascimento.twpt.components.ProgressBar;
import net.wesleynascimento.twpt.components.TWLabel;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Wesley on 30/08/2014.
 */
public class UpdateFrame extends FrameDecorator implements FileDownloaderDelegate {

    private final double currentVersion = 0.1000;
    private final String packagePath = "";

    private ProgressBar progressBar;
    private TWLabel progressLabel;

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

    }

    public void loadLocalFiles(){
        //Cria a instancia static do Configuration e do WorldManager
    }

    public void loadRemoteFile(){
        try {
            JSONObject packageFile = JSONFactory.getJSON(packagePath);
        } catch (IOException ex){
            //Case do not find remote package

            return;
        }
    }

    public void checkForAppUpdates(){

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
