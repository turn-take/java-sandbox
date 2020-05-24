package java_gold.ch11;

import java.util.ArrayList;
import java.util.List;

public class TryWithResource {
    public static void main(String[] args) {
        // closeはインスタンス生成の逆順で実施される。
        try(NetworkMonitor networkMonitor = new NetworkMonitor();
            PacketFilter packetFilter = new PacketFilter()) {
            networkMonitor.monitor();
            packetFilter.filter();
        } catch (Exception e) {
            // catchブロックに入るのはリソースのクローズの後
            System.out.println(e.getMessage());
        }
    }
}

class NetworkMonitor implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Monitor closed.");
    }

    public void monitor() throws Exception {
        System.out.println("Monitoring...");
        throw new Exception("Unable to monitor.");
    }
}

class PacketFilter implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Filter closed.");
    }

    public void filter() {
        System.out.println("filtering...");
    }
}