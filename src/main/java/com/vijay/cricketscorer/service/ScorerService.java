package com.vijay.cricketscorer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.cricketscorer.entity.Match;
import com.vijay.cricketscorer.entity.MatchPlayer;
import com.vijay.cricketscorer.entity.Player;
import com.vijay.cricketscorer.entity.Team;
import com.vijay.cricketscorer.model.BatsmanDto;
import com.vijay.cricketscorer.model.BowlerDto;
import com.vijay.cricketscorer.model.CardDto;
import com.vijay.cricketscorer.model.ScorecardDto;
import com.vijay.cricketscorer.repository.MatchPlayerRepository;
import com.vijay.cricketscorer.repository.MatchRepository;
import com.vijay.cricketscorer.repository.PlayerRepository;
import com.vijay.cricketscorer.repository.TeamRepository;

@Service
public class ScorerService {

	Logger log =  Logger.getLogger(ScorerService.class.getName());
	
	@Autowired
    private MatchRepository matchRepo;
	
	@Autowired
    private TeamRepository teamRepo;
	
	@Autowired
    private PlayerRepository playerRepo;
	
	@Autowired
    private MatchPlayerRepository matchPlayerRepo;

    public List<Match> findAllMatches() {

    	List<Match> matches = (List<Match>) matchRepo.findAll();
        
        matches.forEach((match) -> System.out.println(match.toString()));
        
        return matches;
    }

	public List<Team> findAllTeams() {
		List<Team> teams = (List<Team>) teamRepo.findAll();
        
		teams.forEach((team) -> System.out.println(team.toString()));
        
        return teams;
	}
	
	public List<Player> findAllPlayers() {
		List<Player> players = (List<Player>) playerRepo.findAll();
        
		//players.forEach((player) -> System.out.println(player.toString()));
        
        return players;
	}

	public Optional<Team> findUserValid(String userName, String password) {
		List<Team> teams = findAllTeams();
		Optional<Team> finalTeam = teams.stream().filter(team -> team.getTeam_name().equalsIgnoreCase(userName) && team.getTeam_pass().equalsIgnoreCase(password)).findFirst();
		if (!finalTeam.isPresent()) {
			log.severe("Unauthorized access");
		}
		return finalTeam;
	}
	
	public List<Player> addPlayer(String playerName, Integer team_no) {
		if (team_no == null) {
			return new ArrayList<Player>();
		}
		Optional<Team> team = findAllTeams().stream().filter(t -> t.getTeam_no() == team_no).findFirst();
		Player player = new Player();
		player.setPlayer_name(playerName);
		player.setTeam(team.get());
		playerRepo.save(player);
		return playerRepo.findByTeam(team.get());
	}

	public List<Player> getPlayers(Integer team_no) {
		List<Player> players = new ArrayList<Player>();
		if (team_no == null) {
			return players;
		}
		Optional<Team> team = teamRepo.findById(team_no);
		players =  playerRepo.findByTeam(team.get());
		return players;
	}

	public ScorecardDto getScorecardByMatch(Integer match_no) {
		
		ScorecardDto scorecardDto = new ScorecardDto();
		if (match_no == null) {
			return scorecardDto;
		}
		List<MatchPlayer> matchPlayers = new ArrayList<MatchPlayer>();
		//List<MatchPlayer> scorecard = matchPlayerRepo.findByMatch_no(match_no);
		matchPlayers = getDummyScorecard(match_no, matchPlayers);
		CardDto firstCardDto = new CardDto();
		CardDto secondCardDto = new CardDto();
		firstCardDto.setTotal(0);
		secondCardDto.setTotal(0);
		for(MatchPlayer matchPlayer: matchPlayers) {
			BatsmanDto batsmanDto = new BatsmanDto();
			BowlerDto bowlerDto = new BowlerDto();
			
			batsmanDto.setBatsmanNo(matchPlayer.getPlayerNo().getPlayer_no());
			batsmanDto.setBatsman(matchPlayer.getPlayerNo().getPlayer_name());
			batsmanDto.setBalls(matchPlayer.getBalls_faced());
			if (matchPlayer.getBowler() != null) {
				batsmanDto.setBowler(matchPlayer.getBowler().getPlayer_name());
				if (matchPlayer.getFielder() != null) {
					batsmanDto.setFielder(matchPlayer.getFielder().getPlayer_name());
				}
				
			}
			
			batsmanDto.setFours(matchPlayer.getFours());
			batsmanDto.setSixes(matchPlayer.getSixes());
			if (matchPlayer.getOut() != null) {
				batsmanDto.setOutBy(matchPlayer.getOut());
			} else {
				batsmanDto.setOutBy("not out");
			}
			batsmanDto.setRunstaken(matchPlayer.getRuns_taken());
			
			bowlerDto.setBowlerName(matchPlayer.getPlayerNo().getPlayer_name());
			bowlerDto.setBowlerNo(matchPlayer.getPlayerNo().getPlayer_no());
			bowlerDto.setByes(matchPlayer.getByes());
			bowlerDto.setNoBalls(matchPlayer.getNo_balls());
			Integer balls = matchPlayer.getBalls_bowled();
			
			int remBalls =  balls % 6;
			int overs = (balls - remBalls) / 6;
			bowlerDto.setOvers(overs + "." + remBalls);
			bowlerDto.setRunsgiven(matchPlayer.getRuns_given());
			bowlerDto.setWickets(matchPlayer.getWickets());
			bowlerDto.setWides(matchPlayer.getWides());
			
			if (matchPlayer.getMatchNo().getBattingfirst().getTeam_no().equals(matchPlayer.getPlayerNo().getTeam().getTeam_no())) {
				firstCardDto.getBatsmen().add(batsmanDto);
				firstCardDto.setTotal(firstCardDto.getTotal() + batsmanDto.getRunstaken());
				if (balls != 0) {
					secondCardDto.getBowlers().add(bowlerDto);
					secondCardDto.setTotal(secondCardDto.getTotal() + bowlerDto.getByes() + bowlerDto.getNoBalls() + bowlerDto.getWides());
				}
			} else {
				secondCardDto.getBatsmen().add(batsmanDto);
				secondCardDto.setTotal(secondCardDto.getTotal() + batsmanDto.getRunstaken());
				if (balls != 0) {
					firstCardDto.getBowlers().add(bowlerDto);
					firstCardDto.setTotal(firstCardDto.getTotal() + bowlerDto.getByes() + bowlerDto.getNoBalls() + bowlerDto.getWides());
				}
			}
			scorecardDto.setFirstInnings(firstCardDto);
			scorecardDto.setSecondInnings(secondCardDto);
		}
		return scorecardDto;
	}

	private List<MatchPlayer> getDummyScorecard(Integer match_no, List<MatchPlayer> scorecard) {
		
		Team team1 = new Team();
		team1.setTeam_no(1);
		team1.setTeam_name("team1");
		Team team2 = new Team();
		team2.setTeam_no(2);
		team2.setTeam_name("team2");
		Match match = new Match();
		match.setDate("asd");
		match.setMatch_no(match_no);
		match.setTeam_a(team1);
		match.setTeam_b(team2);
		match.setTeam_win(team1);
		match.setTime("234");
		match.setUmpire_team(team2);
		match.setVenue("skdhfdfhk");
		match.setBattingfirst(team1);
		Player player1 = new Player();
		player1.setPlayer_name("Vijay Sundaresan");
		player1.setPlayer_no(1);
		player1.setTeam(team1);
		Player player2 = new Player();
		player2.setPlayer_name("Dinesh Shankar");
		player2.setPlayer_no(1);
		player2.setTeam(team2);
		
		MatchPlayer matchPlayer1 = new MatchPlayer();
		matchPlayer1.setBalls_bowled(24);
		matchPlayer1.setBalls_faced(34);
		matchPlayer1.setByes(0);
		matchPlayer1.setFours(0);
		matchPlayer1.setMatchNo(match);
		matchPlayer1.setNo_balls(3);
		matchPlayer1.setWides(4);
		matchPlayer1.setPlayerNo(player1);
		matchPlayer1.setPlayer_match_no(1);
		matchPlayer1.setRuns_given(19);
		matchPlayer1.setRuns_taken(17);
		matchPlayer1.setSixes(1);
		matchPlayer1.setWickets(2);
		MatchPlayer matchPlayer2 = new MatchPlayer();
		matchPlayer2.setBalls_bowled(20);
		matchPlayer2.setBalls_faced(12);
		matchPlayer2.setByes(2);
		matchPlayer2.setFours(1);
		matchPlayer2.setMatchNo(match);
		matchPlayer2.setNo_balls(2);
		matchPlayer2.setWides(3);
		matchPlayer2.setPlayer_match_no(2);
		matchPlayer2.setPlayerNo(player2);
		matchPlayer2.setPlayer_match_no(1);
		matchPlayer2.setRuns_given(21);
		matchPlayer2.setRuns_taken(12);
		matchPlayer2.setSixes(0);
		matchPlayer2.setWickets(1);
		scorecard.add(matchPlayer1);
		scorecard.add(matchPlayer2);
		
		return scorecard;
	}

	public String saveScorecard(CardDto cardDto) {
		String result = "Card Added";
		Integer matchNo = cardDto.getMatchNo();
		Match match = matchRepo.findById(matchNo).get();
		Team team = findAllTeams().stream().filter((t) -> t.getTeam_name().equals(cardDto.getMatchWonBy())).findFirst().get();
		List<MatchPlayer> matchPlayers = matchPlayerRepo.findByMatchNo(match);
		cardDto.getBatsmen().forEach((batsman) -> {
			Player player = playerRepo.findById(batsman.getBatsmanNo()).get();
			MatchPlayer mPlayer = new MatchPlayer();
			for (MatchPlayer matchPlayer : matchPlayers) {
				if (matchPlayer.getPlayerNo().getPlayer_no().equals(player.getPlayer_no())) {
					mPlayer = matchPlayer;
					break;
				}
			} 
			if (batsman.getBowler() != null && !batsman.getBowler().isBlank()) {
				mPlayer.setBowler(playerRepo.findById(Integer.valueOf(batsman.getBowler())).get());
			}
			if (batsman.getFielder() != null && !batsman.getFielder().isBlank()) {
				mPlayer.setFielder(playerRepo.findById(Integer.valueOf(batsman.getFielder())).get());
			}
			mPlayer.setBalls_faced(batsman.getBalls());
			mPlayer.setFours(batsman.getFours());
			mPlayer.setOut(batsman.getOutBy());
			mPlayer.setPlayerNo(player);
			mPlayer.setMatchNo(match);
			mPlayer.setRuns_taken(batsman.getRunstaken());
			mPlayer.setSixes(batsman.getSixes());
			matchPlayerRepo.save(mPlayer);
			if (cardDto.getFirstInnings().equals("true") && match.getBattingfirst() == null) {
				match.setBattingfirst(player.getTeam());
			}
		});
		
		if (match.getTeam_win() == null) {
			match.setTeam_win(team);
			if(team.getMatch_pts() == null) {
				team.setMatch_pts(0);
			}
			team.setMatch_pts(team.getMatch_pts() + 2);
			matchRepo.save(match);
		}
		
		cardDto.getBowlers().forEach((bowler) -> {
			Player player = playerRepo.findById(bowler.getBowlerNo()).get();
			MatchPlayer mPlayer = new MatchPlayer();
			for (MatchPlayer matchPlayer : matchPlayers) {
				if (matchPlayer.getPlayerNo().getPlayer_no().equals(player.getPlayer_no())) {
					mPlayer = matchPlayer;
					break;
				}
			} 
			mPlayer.setBalls_bowled(Integer.valueOf(bowler.getOvers()));
			mPlayer.setByes(bowler.getByes());
			mPlayer.setMatchNo(match);
			mPlayer.setNo_balls(bowler.getNoBalls());
			mPlayer.setPlayerNo(player);
			mPlayer.setRuns_given(bowler.getRunsgive());
			mPlayer.setWickets(bowler.getWickets());
			mPlayer.setWides(bowler.getWides());
			matchPlayerRepo.save(mPlayer);
		});
		
		return result;
	}

}
