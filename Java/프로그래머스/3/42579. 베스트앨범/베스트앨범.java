import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // init
        HashMap<String, Integer> genrePlay = new HashMap<>(); // {장르, 총 재생횟수}
        HashMap<String, List<int[]>> genreSongs = new HashMap<>(); // {장르, [고유번호, 재생횟수]}
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            genrePlay.put(genre, genrePlay.getOrDefault(genre, 0) + play);
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i, play});
        }
        
        // 1. 장르 정렬, 총 재생횟수 기준(내림차순)
        List<String> sortedGenre = new ArrayList<>(genrePlay.keySet());
        sortedGenre.sort((a, b) -> genrePlay.get(b) - genrePlay.get(a));
        
        List<Integer> bestAlbum = new ArrayList<>();
        for(String genre : sortedGenre){
            List<int[]> songs = genreSongs.get(genre);
            // 2. 장르 내 노래 정렬, 재생횟수 기준(내림차순). 같을 시 고유번호(오름차순)
            songs.sort((a, b) -> {
                if(a[1]!=b[1]) return b[1] - a[1];
                else return a[0] - b[0];
            });
            // 3. 앨범 수록
            bestAlbum.add(songs.get(0)[0]);
            if(songs.size()>1) bestAlbum.add(songs.get(1)[0]);
        }
        
        return bestAlbum.stream().mapToInt(Integer::intValue).toArray();
    }
}