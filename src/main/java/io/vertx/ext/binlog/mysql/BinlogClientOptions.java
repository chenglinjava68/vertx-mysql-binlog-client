package io.vertx.ext.binlog.mysql;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class BinlogClientOptions {

  private String host = "localhost";

  private int port = 3306;

  private String username = "root";

  private String password;

  private boolean publishMessage;

  private boolean sendMessage;

  private long connectTimeout = TimeUnit.SECONDS.toMillis(30);

  private String filename;

  private long position = -1;

  private boolean keepAlive = true;

  private long keepAliveInterval = TimeUnit.MINUTES.toMillis(1);

  private long heartbeatInterval = 0;

  public boolean isPublishMessage() {
    return publishMessage;
  }

  public BinlogClientOptions setPublishMessage(boolean publishMessage) {
    this.publishMessage = publishMessage;
    return this;
  }

  public boolean isSendMessage() {
    return sendMessage;
  }

  public BinlogClientOptions setSendMessage(boolean sendMessage) {
    this.sendMessage = sendMessage;
    return this;
  }

  public long getHeartbeatInterval() {
    return heartbeatInterval;
  }

  public BinlogClientOptions setHeartbeatInterval(long heartbeatInterval) {
    this.heartbeatInterval = heartbeatInterval;
    return this;
  }

  public boolean isKeepAlive() {
    return keepAlive;
  }

  public BinlogClientOptions setKeepAlive(boolean keepAlive) {
    this.keepAlive = keepAlive;
    return this;
  }

  public long getKeepAliveInterval() {
    return keepAliveInterval;
  }

  public BinlogClientOptions setKeepAliveInterval(long keepAliveInterval) {
    this.keepAliveInterval = keepAliveInterval;
    return this;
  }

  public long getPosition() {
    return position;
  }

  public BinlogClientOptions setPosition(long position) {
    this.position = position;
    return this;
  }

  public String getFilename() {
    return filename;
  }

  public BinlogClientOptions setFilename(String filename) {
    this.filename = filename;
    return this;
  }

  public long getConnectTimeout() {
    return connectTimeout;
  }

  public BinlogClientOptions setConnectTimeout(long connectTimeout) {
    this.connectTimeout = connectTimeout;
    return this;
  }

  public String getHost() {
    return host;
  }

  public BinlogClientOptions setHost(String host) {
    this.host = host;
    return this;
  }

  public int getPort() {
    return port;
  }

  public BinlogClientOptions setPort(int port) {
    this.port = port;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public BinlogClientOptions setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public BinlogClientOptions setPassword(String password) {
    this.password = password;
    return this;
  }

}
