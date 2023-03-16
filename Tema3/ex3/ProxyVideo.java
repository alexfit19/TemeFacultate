package isp.lab5.exercise3;

public class ProxyVideo implements Playable{
    private ColorVideo video;
    private String fileName;

    public ProxyVideo(BlackAndWhiteVideo b){
        this.fileName = b.fileName;
        this.video = b;
    }
    public ProxyVideo(ColorVideo c){
        this.fileName = c.fileName;
        this.video = c;
    }

    @Override
    public void play() {
        if(video == null){
            video = new ColorVideo();
        }
        video.play();
    }
}
