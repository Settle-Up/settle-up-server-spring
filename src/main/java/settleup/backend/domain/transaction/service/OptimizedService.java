package settleup.backend.domain.transaction.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import settleup.backend.domain.transaction.entity.dto.TransactionDto;
import settleup.backend.domain.transaction.entity.dto.TransactionP2PResultDto;
import settleup.backend.global.exception.CustomException;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface OptimizedService {

    TransactionP2PResultDto optimizationOfp2p(TransactionDto targetDto) throws CustomException;

}
