package isp.lab5.exercise3;

public class BlackAndWhiteVideo extends ColorVideo implements Playable{
    private ColorVideo video;
    String fileName;

    public BlackAndWhiteVideo(String fileName) {
        super();
        this.video = video;
        this.fileName = fileName;
    }
    @Override
    public void play() {
        if(video == null){
            video = new ColorVideo(fileName);
        }
        System.out.println("Play black and white video " + video.fileName);
    }
}
