package Funding.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Funding.model.vo.AdminFunding;
import Funding.model.vo.Demand;
import Funding.model.vo.DemandList;


public class DemandDAO {
	private Properties prop = new Properties();
	
	public DemandDAO() {
		String fileName = DemandDAO.class.getResource("/sql/Funding/demand-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 사용자가 보는 펀딩 리스트 카운트
	public int getListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	
	// 사용자가 보는 펀딩  정렬 리스트 카운트
	public int getSortListCount(Connection conn, String cinema) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("SortListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cinema);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
		
	// 관리자가 보는 펀딩 리스트 카운트
	public int getAdListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("AdminListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	// 관리자가 보는 펀딩 정렬 리스트 카운트
	public int getAdSortListCount(Connection conn, String cinema) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("AdminSortListCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cinema);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
		
	//관리자가 글게시물을 활성화시켰을때 리스트
	public ArrayList<DemandList> selectList(Connection conn, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DemandList> list = new ArrayList<DemandList>();
		
		String query = prop.getProperty("SelectList");
		
		int start = (currentPage - 1 ) * boardLimit + 1;
		int end = start + boardLimit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DemandList dl = new DemandList(rset.getInt("DNO"),
											   rset.getInt("FNO"),
											   rset.getString("TITLE"),
											   rset.getString("FNAME"),
											   rset.getInt("PRICE"),
											   rset.getInt("DDAY"));
				
				list.add(dl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	
	//관리자가 글게시물을 활성화시키기전  리스트
	public ArrayList<DemandList> AdminFunding(Connection conn, int currentPage, int boardLimit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DemandList> list = new ArrayList<DemandList>();
		
		String query = prop.getProperty("AdminFList");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, currentPage);
			pstmt.setInt(2, boardLimit);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				DemandList dl = new DemandList(rset.getInt("DNO"),
											   rset.getInt("FNO"),
											   rset.getString("TITLE"),
											   rset.getString("FNAME"),
											   rset.getInt("PRICE"),
											   rset.getInt("DDAY"));
				list.add(dl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	
	public int insertDemand(Connection conn, Demand d) {
        PreparedStatement pstmt = null;
        int result = 0;
        String sql = prop.getProperty("insertDemand");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, d.getUserId());
            pstmt.setInt(2, d.getSmNo());
            pstmt.setInt(3, d.getFileNo());
            pstmt.setString(4, d.getMovieTitle());
            pstmt.setString(5, d.getMovieDirector());
            pstmt.setString(6, d.getMovieActor());
            pstmt.setString(7, d.getMovieStory());
            pstmt.setInt(8, d.getWantMoney());
            pstmt.setInt(9, d.getMoney());
            pstmt.setInt(10, d.getGerneNo());
            pstmt.setString(11, d.getRunningTime());
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
	
	public ArrayList<Demand> wantPeople(Connection conn) {
		//SELECT DEMAND_SURVEY_NO, SUM(PRICE) CNT FROM TB_WANT GROUP BY DEMAND_SURVEY_NO;
		Statement stmt = null;
		ResultSet rset = null;
		Demand d = null;
		ArrayList<Demand> want = new ArrayList<Demand>();
		
		String query = prop.getProperty("WantPeople");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				d = new Demand(rset.getInt("DEMAND_SURVEY_NO"),
							   rset.getInt("CNT"));
				want.add(d);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return want;
	}
	
	public Demand getDemand(Connection conn, int no) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Demand d = null;

        String sql = prop.getProperty("getDemand");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                d = new Demand(rs.getInt("DEMAND_SURVEY_NO"),
                               rs.getString("USER_ID"),
                               rs.getInt("SCREENING_MOVIE_NO"),
                               rs.getInt("cnt"),
                               rs.getInt("FILE_NO"),
                               rs.getString("movie_title"),
                               rs.getString("movie_director"),
                               rs.getString("movie_actor"),
                               rs.getString("movie_story"),
                               rs.getInt("demand_want_price"),
                               rs.getInt("demand_price"),
                               rs.getDate("demand_start_date"),
                               rs.getDate("DEMAND_END_DATE"),
                               rs.getInt("GENRE_NO"),
                               rs.getString("running_time")
                               );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return d;
    }
	public String getFile(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String fName = "";
		
		String sql = prop.getProperty("getFile");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fName = rs.getString("FILE_NEWNAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return fName;
	}
	public String getGenre(Connection conn, int gerneNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String genre = "";
		
		String sql = prop.getProperty("getGenre");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gerneNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				genre = rs.getString("genre");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return genre;
	}
	public String getScreen(Connection conn, int smNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String smName = "";
		
		String sql = prop.getProperty("getScreen");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, smNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				smName = rs.getString("SCREENING_MOVIE_NAME");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return smName;
	}
	public char getFund(Connection conn, String userId, int no, String duserId) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        char chk = 0;

        String sql = prop.getProperty("getFund");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setInt(2, no);
            pstmt.setString(3, duserId);

            rs = pstmt.executeQuery();
            if(rs.next()) {
                chk = (char)rs.getInt("price");
            }else {
                chk = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }
        return chk;
    }
    public int putFund(Connection conn, int no, String userId, String dUserId, int price) {
        PreparedStatement pstmt = null;
        int result = 0;

        String sql = prop.getProperty("putFund");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setInt(2, no);
            pstmt.setString(3, dUserId);
            pstmt.setInt(4, price);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
public int notFund(Connection conn, int no, String userId, String dUserId) {
        PreparedStatement pstmt = null;
        int result = 0;

        String sql = prop.getProperty("notFund");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setInt(2, no);
            pstmt.setString(3, dUserId);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
	public ArrayList<DemandList> SortList(Connection conn, int currentPage, int boardLimit, String cinema) {
		//SELECT * FROM SORTLIST WHERE (RNUM BETWEEN ? AND ?) AND SM_NAME LIKE ?
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DemandList> list = new ArrayList<DemandList>();
		
		String query = prop.getProperty("SortList");
		
		int start = (currentPage - 1 ) * boardLimit + 1;
		int end = start + boardLimit - 1;
		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, cinema);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				DemandList dl = new DemandList(rset.getInt("DNO"),
											   rset.getInt("FNO"),
											   rset.getString("TITLE"),
											   rset.getString("FNAME"),
											   rset.getInt("PRICE"),
											   rset.getInt("DDAY"));
				list.add(dl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<DemandList> AdminSortList(Connection conn, int currentPage, int boardLimit, String cinema) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DemandList> list = new ArrayList<DemandList>();
		
		String query = prop.getProperty("AdminSortList");
		
		int start = (currentPage - 1 ) * boardLimit + 1;
		int end = start + boardLimit - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			pstmt.setString(3, cinema);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				DemandList dl = new DemandList(rset.getInt("DNO"),
											   rset.getInt("FNO"),
											   rset.getString("TITLE"),
											   rset.getString("FNAME"),
											   rset.getInt("PRICE"),
											   rset.getInt("DDAY"));
				list.add(dl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public ArrayList<AdminFunding> FunDetail(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminFunding> list = new ArrayList<AdminFunding>();
		
		String query = prop.getProperty("FunDetail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				AdminFunding af = new AdminFunding(rset.getInt("DNO"),
												   rset.getString("FNEW"),
												   rset.getString("TITLE"),
												   rset.getString("ACTOR"),
												   rset.getString("DIRECTOR"),
												   rset.getString("STORY"),
												   rset.getString("SMNAME"),
												   rset.getInt("MAXPEOPLE"),
												   rset.getString("GENRE"),
												   rset.getString("RTIME"),
												   rset.getInt("WANT_PRICE"),
												   rset.getInt("PRICE"));
				list.add(af);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
	
	
