/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.mixers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newCachedThreadPool;
import javax.sound.sampled.AudioFormat;
import static javax.sound.sampled.AudioSystem.getSourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import static webcamstudio.WebcamStudio.audioFreq;
import webcamstudio.components.PreViewer;
import static webcamstudio.util.Tools.sleep;

/**
 *
 * @author patrick (modified by karl)
 */
public class PrePlayer implements Runnable {
    private static PrePlayer preInstance = null;

    public static PrePlayer getPreInstance(PreViewer viewer) {
        if (preInstance == null) {
            preInstance = new PrePlayer(viewer);
        }
        return preInstance;
    }

    boolean stopMe = false;
    public boolean stopMePub = stopMe;
    private SourceDataLine source;
    private ExecutorService executor = null;
    private final ArrayList<byte[]> buffer = new ArrayList<>();
    private FrameBuffer frames = null;
    private PreViewer preViewer = null;
    private final int aFreq = audioFreq;
    
    private PrePlayer(PreViewer viewer) {
        this.preViewer = viewer;
    }

    public void addFrame(Frame frame) {
        BufferedImage fImage = frame.getImage();
        preViewer.setImage(fImage);
        int lAL = PreviewMixer.getInstance().getAudioLevelLeft();
        int lAR = PreviewMixer.getInstance().getAudioLevelRight();
        preViewer.setAudioLevel(lAL, lAR);
        preViewer.repaint();
        if (source != null) {
            frames.push(frame);
        }
    }

    public void play() throws LineUnavailableException {
        frames = new FrameBuffer(MasterMixer.getInstance().getWidth(), MasterMixer.getInstance().getHeight(), MasterMixer.getInstance().getRate());
        AudioFormat format = new AudioFormat(audioFreq, 16, 2, true, true);
        source = getSourceDataLine(format);
        source.open();
        source.start();
        executor = newCachedThreadPool();
        executor.submit(this);
        executor.shutdown();
    }

    @Override
    public void run() {
        stopMe = false;
        frames.clear();
        while (!stopMe) {
            Frame frame = frames.pop();
            byte[] d = frame.getAudioData();
            if (d != null) {
                source.write(d, 0, d.length);
            }
        }
    }

    public void stop() {
        stopMe = true;
        if (frames != null) {
            sleep(30);
            frames.abort();
        }
        if (source != null) {
            sleep(30);
            source.stop();
            sleep(30);
            source.close();
            sleep(30);
            source = null;
        }
        sleep(20);
        executor = null;
    }

}
