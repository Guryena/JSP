package edu.global.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.global.baord.dto.BoardDTO;

public class BoardDAO {
	private DataSource dataSource;

	public BoardDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int delete(String bid) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "DELETE FROM MVC_BOARD WHERE BID = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.valueOf(bid));

			rn = preparedStatement.executeUpdate(); // 업데이트 갯수

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;

	}

	public int modify(String bid, String bname, String btitle, String bcontent) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "UPDATE MVC_BOARD SET BNAME =?, BTITLE = ?, BCONTENT = ? WHERE BID = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.valueOf(bid));

			rn = preparedStatement.executeUpdate(); // 업데이트 갯수

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;

	}

	public BoardDTO contenteView(String strID) {
		BoardDTO board = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "SELECT * FROM MVC_BOARD WHERE BID = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, Integer.valueOf(strID));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bid = resultSet.getInt("bid");

				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");

				Timestamp bdate = resultSet.getTimestamp("bdate");

				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");

				board = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return board;

	}

	public List<BoardDTO> list() {
		List<BoardDTO> boards = new ArrayList<BoardDTO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bid = resultSet.getInt("bid");

				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");

				Timestamp bdate = resultSet.getTimestamp("bdate");

				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");

				BoardDTO dto = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				boards.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return boards;

	}

	public int write(String bname, String btitle, String bcontent) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0 )";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);

			rn = preparedStatement.executeUpdate(); // 업데이트 갯수

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;

	}

	public BoardDTO reply_view(String strID) {
		BoardDTO board = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "SELECT * FROM MVC_BOARD WHERE BID = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, Integer.valueOf(strID));
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bid = resultSet.getInt("bid");

				String bname = resultSet.getString("bname");
				String btitle = resultSet.getString("btitle");
				String bcontent = resultSet.getString("bcontent");

				Timestamp bdate = resultSet.getTimestamp("bdate");

				int bhit = resultSet.getInt("bhit");
				int bgroup = resultSet.getInt("bgroup");
				int bstep = resultSet.getInt("bstep");
				int bindent = resultSet.getInt("bindent");

				board = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return board;

	}

	public int replyShape(String strGroup, String strStep) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strGroup));
			preparedStatement.setInt(2, Integer.parseInt(strStep));

			rn = preparedStatement.executeUpdate(); // 업데이트 갯수

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;

	}

	public int reply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) {

		replyShape(bgroup, bstep);

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, bname);
			preparedStatement.setString(2, btitle);
			preparedStatement.setString(3, bcontent);
			preparedStatement.setInt(4, Integer.valueOf(bgroup));
			preparedStatement.setInt(5, Integer.valueOf(bstep) +1);
			preparedStatement.setInt(6, Integer.valueOf(bindent) + 1);

			rn = preparedStatement.executeUpdate(); // 업데이트 갯수

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;

	}

}
