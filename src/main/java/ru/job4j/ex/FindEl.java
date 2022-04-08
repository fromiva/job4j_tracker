package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element does not exist in the array.");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] protocols = {"BGP", "DHCP(v6)", "DNS", "FTP", "HTTP", "HTTPS", "IMAP",
                "LDAP", "MGCP", "MQTT", "NNTP", "NTP", "OSPF", "POP", "PTP", "ONC/RPC",
                "RTP", "RTSP", "RIP", "SIP", "SMTP", "SNMP", "SSH", "Telnet", "TLS/SSL", "XMPP"};
        String protocol = "FTP";
        try {
            int index = indexOf(protocols, protocol);
            System.out.println("Index: " + index);
        } catch (ElementNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
