import java.util.LinkedList;
import java.util.List;

/**
 * Created by floatec on 5/19/15.
 */

public class MyAsycTask implements Runnable{

    MyCallBack mc;
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> MyList=new LinkedList<String>();
        MyList.add("Hallo");
        mc.callBack(MyList);
    }
    MyAsycTask(MyCallBack mc){
        this.mc=mc;
    }
}
