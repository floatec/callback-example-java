import java.util.List;

/**
 * Created by floatec on 5/19/15.
 */
public class MyClass implements MyCallBack{
    private List<String> msg;

    @Override
    public void callBack(List<String> myData) {
        msg=myData;
    }

    MyClass(){
        //start thred
        Thread networkThread = new Thread(new MyAsycTask(this));;
        try {
            networkThread.setDaemon(false);
            networkThread.start();
            //Join main-thread with Network-Thread to share Domain-Objects
            // The network-thread get an Timeout of 2 Seconds, otherwise, the application will hang
            networkThread.join(7000);
        } catch (InterruptedException e) {
            // ignore
        }
        while (true){
            System.out.print(msg.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
    }

    public static void main(String[] args) {
        new MyClass();
    }

}
