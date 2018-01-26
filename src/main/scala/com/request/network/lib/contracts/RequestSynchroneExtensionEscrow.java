package com.request.network.lib.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class RequestSynchroneExtensionEscrow extends Contract {
    private static final String BINARY = "0x606060405260008060146101000a81548160ff021916908315150217905550341561002957600080fd5b604051602080611ad383398101604052808051906020019091905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506119fd806100d66000396000f3006060604052600436106100e6576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632d83549c146100eb5780633f4ba83a146101a1578063452e79a4146101b65780635c975abb1461021d578063638526e81461024a578063695eda19146102715780636c4fbaa4146102b95780637ee1756a1461030e5780638456cb59146103355780638da5cb5b1461034a578063a05bd4c61461039f578063c4d252f5146103e7578063d29574ba14610426578063e4725ba114610492578063f2fde38b146104d1578063f3479fe81461050a575b600080fd5b34156100f657600080fd5b610110600480803560001916906020019091905050610552565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183600281111561018457fe5b60ff16815260200182815260200194505050505060405180910390f35b34156101ac57600080fd5b6101b46105cf565b005b34156101c157600080fd5b61020360048080356000191690602001909190803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190505061068d565b604051808215151515815260200191505060405180910390f35b341561022857600080fd5b61023061069a565b604051808215151515815260200191505060405180910390f35b341561025557600080fd5b61026f6004808035600019169060200190919050506106ad565b005b341561027c57600080fd5b61029f600480803560001916906020019091908035906020019091905050610b0c565b604051808215151515815260200191505060405180910390f35b34156102c457600080fd5b6102cc610c00565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b341561031957600080fd5b610333600480803560001916906020019091905050610c26565b005b341561034057600080fd5b610348611219565b005b341561035557600080fd5b61035d6112d9565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156103aa57600080fd5b6103cd6004808035600019169060200190919080359060200190919050506112fe565b604051808215151515815260200191505060405180910390f35b34156103f257600080fd5b61040c60048080356000191690602001909190505061148a565b604051808215151515815260200191505060405180910390f35b341561043157600080fd5b61047860048080356000191690602001909190806101200190600980602002604051908101604052809291908260096020028082843782019150505050509190505061154a565b604051808215151515815260200191505060405180910390f35b341561049d57600080fd5b6104b76004808035600019169060200190919050506117e1565b604051808215151515815260200191505060405180910390f35b34156104dc57600080fd5b610508600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506117ec565b005b341561051557600080fd5b610538600480803560001916906020019091908035906020019091905050611941565b604051808215151515815260200191505060405180910390f35b60016020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060010160149054906101000a900460ff16908060020154905084565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561062a57600080fd5b600060149054906101000a900460ff16151561064557600080fd5b60008060146101000a81548160ff0219169083151502179055507f7805862f689e2f13df9f062ff482ad3ad112aca9e0847911ed832e158c525b3360405160405180910390a1565b6000600190509392505050565b600060149054906101000a900460ff1681565b60008060149054906101000a900460ff161515156106ca57600080fd5b813373ffffffffffffffffffffffffffffffffffffffff1660016000836000191660001916815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16148061082957503373ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a12cad70836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b15156107f657600080fd5b6102c65a03f1151561080757600080fd5b5050506040518051905073ffffffffffffffffffffffffffffffffffffffff16145b151561083457600080fd5b82600080600281111561084357fe5b60016000846000191660001916815260200190815260200160002060010160149054906101000a900460ff16600281111561087a57fe5b14151561088657600080fd5b84600180600281111561089557fe5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166309648a9d846000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b151561093657600080fd5b6102c65a03f1151561094757600080fd5b50505060405180519050600281111561095c57fe5b14151561096857600080fd5b600260016000896000191660001916815260200190815260200160002060010160146101000a81548160ff021916908360028111156109a357fe5b021790555086600019167f42b0f31519c4d6f0d5905e3bcbc1081cd5ee948f9aa336ce3857a98407d8687360405160405180910390a26000600160008960001916600019168152602001908152602001600020600201541115610b035760016000886000191660001916815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1695508573ffffffffffffffffffffffffffffffffffffffff1663a05bd4c688600160008b60001916600019168152602001908152602001600020600201546000604051602001526040518363ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180836000191660001916815260200182815260200192505050602060405180830381600087803b1515610ae657600080fd5b6102c65a03f11515610af757600080fd5b50505060405180519050505b50505050505050565b60008060149054906101000a900460ff16151515610b2957600080fd5b823373ffffffffffffffffffffffffffffffffffffffff1660016000836000191660001916815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16141515610ba257600080fd5b610bd3836001600087600019166000191681526020019081526020016000206002015461194d90919063ffffffff16565b60016000866000191660001916815260200190815260200160002060020181905550600191505092915050565b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600060149054906101000a900460ff16151515610c4557600080fd5b823373ffffffffffffffffffffffffffffffffffffffff1660016000836000191660001916815260200190815260200160002060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161480610da357503373ffffffffffffffffffffffffffffffffffffffff16600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1662ca2f75836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b1515610d7057600080fd5b6102c65a03f11515610d8157600080fd5b5050506040518051905073ffffffffffffffffffffffffffffffffffffffff16145b1515610dae57600080fd5b836000806002811115610dbd57fe5b60016000846000191660001916815260200190815260200160002060010160149054906101000a900460ff166002811115610df457fe5b141515610e0057600080fd5b856001806002811115610e0f57fe5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166309648a9d846000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b1515610eb057600080fd5b6102c65a03f11515610ec157600080fd5b505050604051805190506002811115610ed657fe5b141515610ee257600080fd5b60018060008a6000191660001916815260200190815260200160002060010160146101000a81548160ff02191690836002811115610f1c57fe5b021790555087600019167f8f482593d146341944d7bd7864ae7499d8775b00371dc732137341512245363660405160405180910390a26001600089600019166000191681526020019081526020016000206002015496506000600160008a600019166000191681526020019081526020016000206002018190555060016000896000191660001916815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1695506000871115611174578573ffffffffffffffffffffffffffffffffffffffff1663452e79a489600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a12cad708c6000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b151561109f57600080fd5b6102c65a03f115156110b057600080fd5b505050604051805190508a6000604051602001526040518463ffffffff167c01000000000000000000000000000000000000000000000000000000000281526004018084600019166000191681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b151561115757600080fd5b6102c65a03f1151561116857600080fd5b50505060405180519050505b8573ffffffffffffffffffffffffffffffffffffffff1663c4d252f5896000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808260001916600019168152602001915050602060405180830381600087803b15156111f357600080fd5b6102c65a03f1151561120457600080fd5b50505060405180519050505050505050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561127457600080fd5b600060149054906101000a900460ff1615151561129057600080fd5b6001600060146101000a81548160ff0219169083151502179055507f6985a02210a168e66602d3235cb6db0e70f92b3ba4d376a33c0f3d9434bff62560405160405180910390a1565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60008060149054906101000a900460ff1615151561131b57600080fd5b823373ffffffffffffffffffffffffffffffffffffffff1660016000836000191660001916815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561139457600080fd5b8360018060028111156113a357fe5b60016000846000191660001916815260200190815260200160002060010160149054906101000a900460ff1660028111156113da57fe5b141515156113e757600080fd5b611418856001600089600019166000191681526020019081526020016000206002015461196690919063ffffffff16565b6001600088600019166000191681526020019081526020016000206002018190555085600019167f640ab74eaec4a0c0c67aec6ef5873788a00b6ccca55e5e13b23503e46b91b5e6866040518082815260200191505060405180910390a261147f86611984565b935050505092915050565b60008060149054906101000a900460ff161515156114a757600080fd5b813373ffffffffffffffffffffffffffffffffffffffff1660016000836000191660001916815260200190815260200160002060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561152057600080fd5b60006001600085600019166000191681526020019081526020016000206002015414915050919050565b60008060149054906101000a900460ff1615151561156757600080fd5b336001600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f8db71b5836000604051602001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b151561162f57600080fd5b6102c65a03f1151561164057600080fd5b5050506040518051905060ff1614151561165957600080fd5b600060010283600060098110151561166d57fe5b602002015160001916141580151561168457600080fd5b6080604051908101604052803373ffffffffffffffffffffffffffffffffffffffff1681526020018560006009811015156116bb57fe5b60200201516001900473ffffffffffffffffffffffffffffffffffffffff168152602001600060028111156116ec57fe5b8152602001600081525060016000876000191660001916815260200190815260200160002060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160010160146101000a81548160ff021916908360028111156117c357fe5b02179055506060820151816002015590505060019250505092915050565b600060019050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561184757600080fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161415151561188357600080fd5b8073ffffffffffffffffffffffffffffffffffffffff166000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a3806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60006001905092915050565b600082821115151561195b57fe5b818303905092915050565b600080828401905083811015151561197a57fe5b8091505092915050565b600060028081111561199257fe5b60016000846000191660001916815260200190815260200160002060010160149054906101000a900460ff1660028111156119c957fe5b1490509190505600a165627a7a72305820f9d1ed1faaf07b743da0ae28ffadad7dd52a901b2838aa74b9cab5a3b971d28d0029";

    protected RequestSynchroneExtensionEscrow(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RequestSynchroneExtensionEscrow(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<EscrowPaymentEventResponse> getEscrowPaymentEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("EscrowPayment", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<EscrowPaymentEventResponse> responses = new ArrayList<EscrowPaymentEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            EscrowPaymentEventResponse typedResponse = new EscrowPaymentEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<EscrowPaymentEventResponse> escrowPaymentEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("EscrowPayment", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, EscrowPaymentEventResponse>() {
            @Override
            public EscrowPaymentEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                EscrowPaymentEventResponse typedResponse = new EscrowPaymentEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<EscrowReleaseRequestEventResponse> getEscrowReleaseRequestEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("EscrowReleaseRequest", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<EscrowReleaseRequestEventResponse> responses = new ArrayList<EscrowReleaseRequestEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            EscrowReleaseRequestEventResponse typedResponse = new EscrowReleaseRequestEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<EscrowReleaseRequestEventResponse> escrowReleaseRequestEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("EscrowReleaseRequest", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, EscrowReleaseRequestEventResponse>() {
            @Override
            public EscrowReleaseRequestEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                EscrowReleaseRequestEventResponse typedResponse = new EscrowReleaseRequestEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<EscrowRefundRequestEventResponse> getEscrowRefundRequestEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("EscrowRefundRequest", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<EscrowRefundRequestEventResponse> responses = new ArrayList<EscrowRefundRequestEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            EscrowRefundRequestEventResponse typedResponse = new EscrowRefundRequestEventResponse();
            typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<EscrowRefundRequestEventResponse> escrowRefundRequestEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("EscrowRefundRequest", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, EscrowRefundRequestEventResponse>() {
            @Override
            public EscrowRefundRequestEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                EscrowRefundRequestEventResponse typedResponse = new EscrowRefundRequestEventResponse();
                typedResponse.requestId = (byte[]) eventValues.getIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<PauseEventResponse> getPauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<PauseEventResponse> responses = new ArrayList<PauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            PauseEventResponse typedResponse = new PauseEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PauseEventResponse> pauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Pause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PauseEventResponse>() {
            @Override
            public PauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PauseEventResponse typedResponse = new PauseEventResponse();
                return typedResponse;
            }
        });
    }

    public List<UnpauseEventResponse> getUnpauseEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<UnpauseEventResponse> responses = new ArrayList<UnpauseEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            UnpauseEventResponse typedResponse = new UnpauseEventResponse();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<UnpauseEventResponse> unpauseEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Unpause", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, UnpauseEventResponse>() {
            @Override
            public UnpauseEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                UnpauseEventResponse typedResponse = new UnpauseEventResponse();
                return typedResponse;
            }
        });
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses = new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<OwnershipTransferredEventResponse> ownershipTransferredEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("OwnershipTransferred", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList());
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, OwnershipTransferredEventResponse>() {
            @Override
            public OwnershipTransferredEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<Tuple4<String, String, BigInteger, BigInteger>> escrows(byte[] param0) {
        final Function function = new Function("escrows", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, String, BigInteger, BigInteger>>(
                new Callable<Tuple4<String, String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);;
                        return new Tuple4<String, String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> unpause() {
        Function function = new Function(
                "unpause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> fundOrder(byte[] _requestId, String _recipient, BigInteger _amount) {
        Function function = new Function(
                "fundOrder", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.Address(_recipient), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> paused() {
        Function function = new Function("paused", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> releaseToPayeeAction(byte[] _requestId) {
        Function function = new Function(
                "releaseToPayeeAction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> refund(byte[] _requestId, BigInteger _amount) {
        Function function = new Function(
                "refund", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> requestCore() {
        Function function = new Function("requestCore", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> releaseToPayerAction(byte[] _requestId) {
        Function function = new Function(
                "releaseToPayerAction", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> pause() {
        Function function = new Function(
                "pause", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> owner() {
        Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> payment(byte[] _requestId, BigInteger _amount) {
        Function function = new Function(
                "payment", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> cancel(byte[] _requestId) {
        Function function = new Function(
                "cancel", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createRequest(byte[] _requestId, List<byte[]> _params) {
        Function function = new Function(
                "createRequest", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.StaticArray9<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.Utils.typeMap(_params, org.web3j.abi.datatypes.generated.Bytes32.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> accept(byte[] _requestId) {
        Function function = new Function(
                "accept", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferOwnership(String newOwner) {
        Function function = new Function(
                "transferOwnership", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(newOwner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> updateExpectedAmount(byte[] _requestId, BigInteger _deltaAmount) {
        Function function = new Function(
                "updateExpectedAmount", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(_requestId), 
                new org.web3j.abi.datatypes.generated.Int256(_deltaAmount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<RequestSynchroneExtensionEscrow> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _requestCoreAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_requestCoreAddress)));
        return deployRemoteCall(RequestSynchroneExtensionEscrow.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<RequestSynchroneExtensionEscrow> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _requestCoreAddress) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_requestCoreAddress)));
        return deployRemoteCall(RequestSynchroneExtensionEscrow.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RequestSynchroneExtensionEscrow load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestSynchroneExtensionEscrow(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static RequestSynchroneExtensionEscrow load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestSynchroneExtensionEscrow(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class EscrowPaymentEventResponse {
        public byte[] requestId;

        public BigInteger amount;
    }

    public static class EscrowReleaseRequestEventResponse {
        public byte[] requestId;
    }

    public static class EscrowRefundRequestEventResponse {
        public byte[] requestId;
    }

    public static class PauseEventResponse {
    }

    public static class UnpauseEventResponse {
    }

    public static class OwnershipTransferredEventResponse {
        public String previousOwner;

        public String newOwner;
    }
}
