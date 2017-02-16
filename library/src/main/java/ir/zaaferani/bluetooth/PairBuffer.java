/**
 * Created by Zaaferani on 21/07/2015.
 *
 */

package ir.zaaferani.bluetooth;

public class PairBuffer {
    public byte[] buffer;
    public int bytes;

    PairBuffer(byte[] _buffer, int _bytes){
        buffer = _buffer;
        bytes = _bytes;
    }
}
