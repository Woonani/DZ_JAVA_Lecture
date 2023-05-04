package DTO;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Position {
	private int positionId;
	private String positionName;
}
