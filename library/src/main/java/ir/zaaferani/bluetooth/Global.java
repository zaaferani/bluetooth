/**
 * Created by Zaaferani on 21/05/2015.
 *
 */

package ir.zaaferani.bluetooth;

public class Global {
    public static final int ORIENTATION_SENSOR    = 0;
    public static final int ORIENTATION_PORTRAIT  = 1;
    public static final int ORIENTATION_LANDSCAPE = 2;

    /**
     * Set to true to add debugging code and logging.
     */
    public static final boolean DEBUG = true;

    /**
     * Set to true to log each character received from the remote process to the
     * android log, which makes it easier to debug some kinds of problems with
     * emulating escape sequences and control codes.
     */
    public static final boolean LOG_CHARACTERS_FLAG = DEBUG && false;

    /**
     * Set to true to log unknown escape sequences.
     */
    public static final boolean LOG_UNKNOWN_ESCAPE_SEQUENCES = DEBUG && false;

    /**
     * The tag we use when logging, so that our messages can be distinguished
     * from other messages in the log. Public because it's used by several
     * classes.
     */
    public static final String LOG_TAG = "CounterInterface";

    // Message types sent from the BluetoothReadService Handler
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_TOAST = 5;

    // Key names received from the BluetoothChatService Handler
    public static final String DEVICE_NAME = "device_name";
    public static final String TOAST = "toast";

    private static final String LOCALECHO_KEY = "localecho";
    private static final String FONTSIZE_KEY = "fontsize";
    private static final String COLOR_KEY = "color";
    private static final String CONTROLKEY_KEY = "controlkey";
    private static final String ALLOW_INSECURE_CONNECTIONS_KEY = "allowinsecureconnections";
    private static final String INCOMING_EOL_0D_KEY = "incoming_eol_0D";
    private static final String INCOMING_EOL_0A_KEY = "incoming_eol_0A";
    private static final String OUTGOING_EOL_0D_KEY = "outgoing_eol_0D";
    private static final String OUTGOING_EOL_0A_KEY = "outgoing_eol_0A";
    private static final String SCREENORIENTATION_KEY = "screenorientation";

    public static final int WHITE = 0xffffffff;
    public static final int BLACK = 0xff000000;
    public static final int BLUE = 0xff344ebd;

    private static final int[][] COLOR_SCHEMES = {
            {BLACK, WHITE}, {WHITE, BLACK}, {WHITE, BLUE}};

//    private static final int[] CONTROL_KEY_SCHEMES = {
//            KeyEvent.KEYCODE_DPAD_CENTER,
//            KeyEvent.KEYCODE_AT,
//            KeyEvent.KEYCODE_ALT_LEFT,
//            KeyEvent.KEYCODE_ALT_RIGHT,
//            KeyEvent.KEYCODE_VOLUME_DOWN,
//            KeyEvent.KEYCODE_VOLUME_UP
//    };
    private static String[] CONTROL_KEY_NAME;

//    private int mControlKeyCode;


}
