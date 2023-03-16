package isp.lab5.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        ProxyVideo v = new ProxyVideo(new BlackAndWhiteVideo("nume"));
        v.play();
        ProxyVideo b = new ProxyVideo(new ColorVideo("nume2"));
        b.play();
    }
}
