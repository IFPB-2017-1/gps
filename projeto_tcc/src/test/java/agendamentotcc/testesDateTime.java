package agendamentotcc;

import java.time.LocalTime;
import java.time.temporal.TemporalQuery;

import br.edu.ifpb.tcc.entity.HorarioEnum;

public class testesDateTime {

	public static void main(String[] args) {

		LocalTime lt1 = LocalTime.of(10, 41);
		System.out.println(lt1.isAfter( HorarioEnum.M5.getInicio()));
	}

}
