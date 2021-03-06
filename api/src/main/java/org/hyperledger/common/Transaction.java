/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hyperledger.common;

/**
 * A transaction in the ledger.
 * A transaction reallocates inputs to outputs. Inputs are outputs of previous transactions.
 */
public class Transaction implements MerkleTreeNode {
    private TID ID;
    private byte [] payload;

    public Transaction(byte [] payload) {
        this.ID = new TID(Hash.of(payload));
        this.payload = payload;
    }

    /**
     * @return 0 since Transaction is always the leaf of the Merkle Tree
     */
    @Override
    public int getMerkleHeight() {
        return 0;
    }


    /**
     * get the Transaction ID
     *
     * @return id
     */
    public TID getID() {
        return ID;
    }

    public byte[] getPayload() {
        return payload;
    }
}
