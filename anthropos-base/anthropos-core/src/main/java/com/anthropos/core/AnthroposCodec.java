package com.anthropos.core;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonObject;

public class AnthroposCodec implements MessageCodec<AnthroposMessage,AnthroposMessage> {
    @Override
    public void encodeToWire(Buffer buffer, AnthroposMessage anthroposMessage) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("requestId", anthroposMessage.getRequestId());
        jsonObject.put("payload", anthroposMessage.getPayload());
        jsonObject.put("errorDesc", anthroposMessage.getErrorDesc());
        jsonObject.put("errorCode", anthroposMessage.getErrorCode());
        jsonObject.put("process",anthroposMessage.isProcess());

        String jsonStr = jsonObject.encode();
        byte[] bytes = jsonStr.getBytes();

        buffer.appendInt(bytes.length);
        buffer.appendBytes(bytes);
    }

    @Override
    public AnthroposMessage decodeFromWire(int pos, Buffer buffer) {
        int length = buffer.getInt(pos);
        pos += 4;

        byte[] bytes = buffer.getBytes(pos, pos + length);
        String jsonStr = new String(bytes);
        JsonObject json = new JsonObject(jsonStr);

        AnthroposMessage message = new AnthroposMessage();
        message.setRequestId(json.getString("requestId"));
        message.setPayload(json.getValue("payload"));
        message.setErrorDesc(json.getString("errorDesc"));
        message.setErrorCode(json.getString("errorCode"));
        message.setProcess(json.getBoolean("process", true));

        return message;
    }

    @Override
    public AnthroposMessage transform(AnthroposMessage anthroposMessage) {
        return anthroposMessage;
    }

    @Override
    public String name() {
        return "AnthroposMessageCodec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
