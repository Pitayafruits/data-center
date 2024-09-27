package com.cc.model.query.request;

import com.cc.model.query.enums.OrganType;
import com.cc.model.query.enums.TableType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class SupportType implements Serializable {
    private OrganType organType;
    private TableType tableType;
}
