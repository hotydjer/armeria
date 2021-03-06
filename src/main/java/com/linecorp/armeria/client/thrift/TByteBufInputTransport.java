/*
 * Copyright 2015 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.armeria.client.thrift;

import java.io.IOException;

import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

class TByteBufInputTransport extends TTransport {
    private final ByteBufInputStream byteBufInputStream;

    TByteBufInputTransport(ByteBuf inputByteBuf) {
        byteBufInputStream = new ByteBufInputStream(inputByteBuf);
    }

    @Override
    public boolean isOpen() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void open() throws TTransportException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int read(byte[] buf, int off, int len) throws TTransportException {
        try {
            return byteBufInputStream.read(buf, off, len);
        } catch (IOException e) {
            throw new TTransportException(e);
        }
    }

    @Override
    public void write(byte[] buf, int off, int len) throws TTransportException {
        throw new UnsupportedOperationException();
    }
}
