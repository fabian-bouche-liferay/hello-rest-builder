package com.liferay.samples.fbo.hello.client.serdes.v1_0_0;

import com.liferay.samples.fbo.hello.client.dto.v1_0_0.Greeting;
import com.liferay.samples.fbo.hello.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Fabian-Liferay
 * @generated
 */
@Generated("")
public class GreetingSerDes {

	public static Greeting toDTO(String json) {
		GreetingJSONParser greetingJSONParser = new GreetingJSONParser();

		return greetingJSONParser.parseToDTO(json);
	}

	public static Greeting[] toDTOs(String json) {
		GreetingJSONParser greetingJSONParser = new GreetingJSONParser();

		return greetingJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Greeting greeting) {
		if (greeting == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (greeting.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(greeting.getMessage()));

			sb.append("\"");
		}

		if (greeting.getPerson() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"person\": ");

			sb.append("\"");

			sb.append(_escape(greeting.getPerson()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		GreetingJSONParser greetingJSONParser = new GreetingJSONParser();

		return greetingJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Greeting greeting) {
		if (greeting == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (greeting.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(greeting.getMessage()));
		}

		if (greeting.getPerson() == null) {
			map.put("person", null);
		}
		else {
			map.put("person", String.valueOf(greeting.getPerson()));
		}

		return map;
	}

	public static class GreetingJSONParser extends BaseJSONParser<Greeting> {

		@Override
		protected Greeting createDTO() {
			return new Greeting();
		}

		@Override
		protected Greeting[] createDTOArray(int size) {
			return new Greeting[size];
		}

		@Override
		protected void setField(
			Greeting greeting, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					greeting.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "person")) {
				if (jsonParserFieldValue != null) {
					greeting.setPerson((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}