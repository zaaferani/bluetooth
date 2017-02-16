/**
 * Created by Zaaferani on 21/07/2015.
 *
 */

package ir.zaaferani.bluetooth;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;


public class HassanView {
    public interface OnFinishCallback {
        public void finished();
    }

    private OnFinishCallback func = null;

    private ByteQueue mByteQueue;

    /**
     * Used to temporarily hold data received from the remote process. Allocated
     * once and used permanently to minimize heap thrashing.
     */
    private byte[] mReceiveBuffer;
    private final int UPDATE = 1;
    private final int CALLBACK = 2;
    private TextView _view;
    private String _data;
    private String finishString;

    public HassanView(TextView v){
        mReceiveBuffer = new byte[4 * 1024];
        mByteQueue = new ByteQueue(4 * 1024);
        _view = v;
        _data = "";
        finishString = null;
    }

    public HassanView(TextView v, String finishString, final OnFinishCallback func){
        mReceiveBuffer = new byte[4 * 1024];
        mByteQueue = new ByteQueue(4 * 1024);
        _view = v;
        _data = "";
        this.finishString = finishString;
        this.func = func;
    }

    private final Handler mHandler = new Handler() {
        /**
         * Handle the callback message. Call our enclosing class's update
         * method.
         *
         * @param msg The callback message.
         */
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == UPDATE) {
                update();
            }else if (msg.what == CALLBACK){
                func.finished();
            }
        }
    };

    public void write(byte[] buffer, int length) {
        try {
            mByteQueue.write(buffer, 0, length);
        } catch (InterruptedException e) {}
        mHandler.sendMessage( mHandler.obtainMessage(UPDATE));
    }

    /**
     * Look for new input from the ptty, send it to the terminal emulator.
     */
    private void update() {
        int bytesAvailable = mByteQueue.getBytesAvailable();
        int bytesToRead = Math.min(bytesAvailable, mReceiveBuffer.length);
        try {
            int bytesRead = mByteQueue.read(mReceiveBuffer, 0, bytesToRead);
            String stringRead = new String(mReceiveBuffer, 0, bytesRead, "UTF-8");
            Log.d("stringRead", "---- :" + stringRead);
            Log.d("stringRead", "---- data:" + _data);
            _data += stringRead;
            _view.setText(_data);
            if (finishString != null && _data.substring(_data.length() - finishString.length()).equals(finishString)) {
                Log.d("stringRead", "---- finish string received");
                if (func != null && getData().length() > 0 ) {
                    Log.d("stringRead", "---- callback function called");
                    mHandler.sendMessage(mHandler.obtainMessage(CALLBACK));
                }
            }
        } catch (InterruptedException ignored) { } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void reset(){
        mReceiveBuffer = new byte[4 * 1024];
        mByteQueue = new ByteQueue(4 * 1024);
        _data = "";
    }

    public String getData(){
        return _data;
    }

    public String getFinishString() {
        return finishString;
    }

    public void setFinishString(String finishString) {
        this.finishString = finishString;
    }

    public OnFinishCallback getOnFinishCallback(){
        return func;
    }
    public void setOnFinishCallback(OnFinishCallback func){
        this.func = func;
    }
}