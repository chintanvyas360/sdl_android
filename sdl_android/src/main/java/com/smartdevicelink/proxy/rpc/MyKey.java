package com.smartdevicelink.proxy.rpc;

import android.support.annotation.NonNull;

import java.util.Hashtable;

import com.smartdevicelink.proxy.RPCStruct;
import com.smartdevicelink.proxy.rpc.enums.VehicleDataStatus;
/** Information related to the MyKey feature.
 * <p><b>Parameter List</b></p>
 * <table border="1" rules="all">
 * 		<tr>
 * 			<th>Param Name</th>
 * 			<th>Type</th>
 * 			<th>Mandatory</th>
 * 			<th>Description</th>
 * 		</tr>
 * 		<tr>
 * 			<td>e911Override</td>
 * 			<td>VehicleDataStatus</td>
 * 			<td>true</td>
 *			<td>Indicates whether e911 override is on.</td>
 * 		</tr>
 *  </table>
 *
 *@since SmartDeviceLink 2.0
 *
 *@see GetVehicleData
 *@see OnVehicleData
 *@see VehicleDataStatus
 * 
 *
 */

public class MyKey extends RPCStruct {
    public static final String KEY_E_911_OVERRIDE = "e911Override";
	/**
	* Constructs a new MyKey object indicated
	*/
    public MyKey() { }
    /**
     * <p>Constructs a new MyKey object indicated by the Hashtable
     * parameter</p>
     * @param hash The Hashtable to use
     */
    public MyKey(Hashtable<String, Object> hash) {
        super(hash);
    }
    /**
     * Constructs a new MyKey object indicated
     */
    public MyKey(@NonNull VehicleDataStatus e911Override) {
        this();
        setE911Override(e911Override);
    }
    public void setE911Override(@NonNull VehicleDataStatus e911Override) {
        setValue(KEY_E_911_OVERRIDE, e911Override);
    }
    public VehicleDataStatus getE911Override() {
        return (VehicleDataStatus) getObject(VehicleDataStatus.class, KEY_E_911_OVERRIDE);
    }
}
