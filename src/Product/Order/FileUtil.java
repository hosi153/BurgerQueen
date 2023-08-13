package Product.Order;

public class FileUtil {

//    String PATH, StringBuffer stringBuffer
//            메서드
//    StringBuffer composeData(Order order) : 영수증 내용 구성
//    StringBuffer saveToFile(Order order) : 영수증을 파일로 저장


    private final String PATH;
    private final StringBuffer stringBuffer;


    public FileUtil(String PATH, StringBuffer stringBuffer) {
        this.PATH = PATH;
        this.stringBuffer = stringBuffer;
    }

    public String getPATH() {

        return PATH;
    }

    public StringBuffer getStringBuffer() {

        return stringBuffer;
    }

//    메서드
//    StringBuffer composeData(Order order) : 영수증 내용 구성
//    StringBuffer saveToFile(Order order) : 영수증을 파일로 저장








}
