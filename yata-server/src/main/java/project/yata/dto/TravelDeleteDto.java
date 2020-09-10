package project.yata.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TravelDeleteDto {
	private Long id;
	private Long accountId;
	private boolean delete;

	@Builder
	public TravelDeleteDto(Long id, Long accountId, boolean delete)
	{
		this.id = id;
		this.accountId = accountId;
		this.delete = delete;
	}

}
