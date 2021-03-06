package io.vertx.ext.binlog.mysql;

import org.junit.Test;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.core.streams.Pump;
import io.vertx.core.streams.WriteStream;

/**
 * @author <a href="mailto:guoyu.511@gmail.com">Guo Yu</a>
 */
public class ReadStreamTest extends BinlogClientTestBase {

  @Test
  public void testPump() throws SQLException {
    TestWriteStream target = new TestWriteStream();
    Pump.pump(client, target).start();
    insert();
    await();
  }

  private class TestWriteStream implements WriteStream<JsonObject> {

    private int counter;

    private int maxSize = 10; //limited buffer size

    private LinkedList<JsonObject> queue = new LinkedList<>();

    private Handler<Void> drainHandler;

    TestWriteStream() {
      new Thread(() -> {
        /*
         * A thread to consume the written data.
         * That simulation a slow write stream
         */
        while(true) {
          try {
            Thread.sleep(20);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          if (queue.poll() != null) {
            counter ++ ;
          }
          if (counter == rows().size()) {
            testComplete();
            return;
          }
          if (drainHandler != null && queue.size() <= maxSize / 2) { //can accept write again
            Handler<Void> handler = drainHandler;
            drainHandler = null;
            handler.handle(null);
          }
        }
      }).start();
    }

    @Override
    public WriteStream<JsonObject> exceptionHandler(Handler<Throwable> handler) {
      return this;
    }

    @Override
    public synchronized WriteStream<JsonObject> write(JsonObject event) {
      logger.info(event.toString());
      queue.push(event);
      return this;
    }

    @Override
    public void end() {

    }

    @Override
    public WriteStream<JsonObject> setWriteQueueMaxSize(int maxSize) {
      this.maxSize = maxSize;
      return this;
    }

    @Override
    public synchronized boolean writeQueueFull() {
      return queue.size() > maxSize / 2;
    }

    @Override
    public WriteStream<JsonObject> drainHandler(Handler<Void> drainHandler) {
      this.drainHandler = drainHandler;
      return this;
    }

  }

}
