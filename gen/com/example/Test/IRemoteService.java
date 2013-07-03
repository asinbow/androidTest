/*___Generated_by_IDEA___*/

/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\asinbowwang\\IdeaProjects\\androidTest\\src\\com\\example\\Test\\IRemoteService.aidl
 */
package com.example.Test;
/**
 * Created with IntelliJ IDEA.
 * User: asinbowwang
 * Date: 13-7-3
 * Time: 涓嬪崍4:01
 * To change this template use File | Settings | File Templates.
 */
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.Test.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.example.Test.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.Test.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.example.Test.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.Test.IRemoteService))) {
return ((com.example.Test.IRemoteService)iin);
}
return new com.example.Test.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.Test.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
}
}
}
