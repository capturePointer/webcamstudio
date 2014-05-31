/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamstudio.streams;

import java.awt.image.BufferedImage;
import static webcamstudio.WebcamStudio.outFFmpeg;
import webcamstudio.externals.ProcessRenderer;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.MasterMixer;

/**
 *
 * @author karl
 */
public class SinkUDP extends Stream {

    private ProcessRenderer capture = null;
    private String standard = "STD";
    protected String abitrate = "128";
    protected String vbitrate = "1200";

    public SinkUDP() {
        name = "UDP";
        if (outFFmpeg){
            this.setComm("FF");
        } else {
            this.setComm("AV");
        }

    }

    @Override
    public void read() {
        rate = MasterMixer.getInstance().getRate();
        captureWidth = MasterMixer.getInstance().getWidth();
        captureHeight = MasterMixer.getInstance().getHeight();
        if (standard.equals("STD")) {
            capture = new ProcessRenderer(this, ProcessRenderer.ACTION.OUTPUT, "udp", comm);
        } else {
            capture = new ProcessRenderer(this, ProcessRenderer.ACTION.OUTPUT, "udpHQ", comm);
        }
        capture.writeCom();
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void stop() {
        if (capture != null) {
            capture.stop();
            capture = null;
        }
        if (this.getBackFF()){
            this.setComm("FF");
        }
    }
    @Override
    public boolean needSeek() {
            return needSeekCTRL=false;
    }
    @Override
    public boolean isPlaying() {
        if (capture != null) {
            return !capture.isStopped();
        } else {
            return false;
        }
    }

    @Override
    public BufferedImage getPreview() {
        return null;
    }
    
    public void setStandard(String gStandard) {
        standard = gStandard;
    }
    
    public String getStandard() {
        return standard;
    }
    
    @Override
    public Frame getFrame() {
        return null;
    }

    @Override
    public boolean hasAudio() {
        return true;
    }

    @Override
    public boolean hasVideo() {
        return true;
    }

    @Override
    public void readNext() {
        
    }

    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     *
     * @return Abitrate
     */
    public String getAbitrate() {
        return abitrate;
    }
    
    public void setAbitrate(String sAbitRate) {
        abitrate = sAbitRate;
    }
    
    /**
     * @return Vbitrate
     */
    public String getVbitrate() {
        return vbitrate;
    }
    
    public void setVbitrate(String sVbitRate) {
        vbitrate = sVbitRate;
    }
}
