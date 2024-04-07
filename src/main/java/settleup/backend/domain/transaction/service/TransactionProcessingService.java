package settleup.backend.domain.transaction.service;

import settleup.backend.domain.group.entity.GroupEntity;
import settleup.backend.domain.transaction.entity.TransactionalEntity;
import settleup.backend.domain.transaction.entity.dto.TransactionUpdateRequestDto;
import settleup.backend.global.exception.CustomException;


public interface TransactionProcessingService {
    TransactionalEntity processTransaction(String transactionId, TransactionUpdateRequestDto request, GroupEntity existingGroup) throws CustomException;

}
