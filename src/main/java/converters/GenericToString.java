
package converters;

import org.springframework.core.convert.converter.Converter;

import domain.DomainEntity;

public class GenericToString<S extends DomainEntity> implements Converter<S, String> {

	@Override
	public String convert(final S source) {
		String res = "";
		if (source == null)
			res = null;
		else
			res = String.valueOf(source.getId());
		return res;
	}
}
