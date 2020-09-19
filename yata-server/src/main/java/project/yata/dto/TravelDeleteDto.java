package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TravelDeleteDto {
	private Long id;
	private Long accountId;
	private boolean deleted;

	@Builder
	public TravelDeleteDto(Long id, Long accountId, boolean deleted)
	{
		this.id = id;
		this.accountId = accountId;
		this.deleted = deleted;
	}

}
