package nextstep.helloworld.jdbc.jdbctemplate;

import nextstep.helloworld.jdbc.Customer;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NamedParamDAO {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParamDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * MapSqlParameterSource
     * public <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType)
     */
    public int useMapSqlParameterSource(String firstName) {
        String sql = "select count(*) from customers where first_name = :first_name";
        final MapSqlParameterSource source = new MapSqlParameterSource("first_name", firstName);
        return namedParameterJdbcTemplate.queryForObject(sql, source, Integer.class);
    }

    /**
     * BeanPropertySqlParameterSource
     * public <T> T queryForObject(String sql, SqlParameterSource paramSource, Class<T> requiredType)
     */
    public int useBeanPropertySqlParameterSource(Customer customer) {
        String sql = "select count(*) from customers where first_name = :firstName";
        final BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(customer);
        return namedParameterJdbcTemplate.queryForObject(sql, source, Integer.class);
    }
}