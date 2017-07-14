package IV;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mellon on 6/16/17.
 */
public class HomeAway {
    public static List<Season> findOverlappingSeasons (List<Season> seasonList) {

        Collections.sort(seasonList, new Comparator<Season>(){
            public int compare(Season s1, Season s2){
                if(s1.getStartDate().equals(s2.getStartDate())) return s1.getEndDate().compareTo(s2.getEndDate());
                return s1.getStartDate().compareTo(s2.getStartDate());
            }
        });

        Set<Season> result = new HashSet<>();
        for(int i=0;i<seasonList.size()-1;i++){
            if(seasonList.get(i + 1).getStartDate().before(seasonList.get(i).getEndDate())){
                result.add(seasonList.get(i));
                result.add(seasonList.get(i+1));
            }
        }
        List<Season> resultAsList = new ArrayList<>();
        resultAsList.addAll(result);
        return resultAsList;
    }

    //combine seasons id 2 & 3 & 4 into a single season
    // keep the name/id of the longest duration season
    public static List<Season> combineOverlappingSeasons (List<Season> seasonList){
        // fist build a nonOverLappingSeasonIds for later filter out nonOverLapping Seasons
        List<Season> nonOverLapping = new ArrayList<>(seasonList);
        List<Season> overlappingSeasons = findOverlappingSeasons(nonOverLapping);
        nonOverLapping.removeAll(overlappingSeasons);
        List<UUID> nonOverLappingSeasonIds = nonOverLapping.stream().map(s -> s.getId()).collect(Collectors.toList());

        // sort input season list
        Collections.sort(seasonList, new Comparator<Season>(){
            public int compare(Season s1, Season s2){
                if(s1.getStartDate().equals(s2.getStartDate())) return s1.getEndDate().compareTo(s2.getEndDate());
                return s1.getStartDate().compareTo(s2.getStartDate());
            }
        });

        // merge seasons with overlapping
        List<Season> mergeResult = new ArrayList<>();
        mergeResult.add(seasonList.get(0));
        for(int i=1;i<seasonList.size();i++){
            // by checking if current season's startDate is before the latest season in the merge list.
            if(seasonList.get(i).getStartDate().before(mergeResult.get(mergeResult.size()-1).getEndDate())){
                // if yes, checking the day range see which season has more days,
                // if a season has more days, remain all fields but changes start date and end date to reflect two merged season start date and end date.
                if(mergeResult.get(mergeResult.size()-1).getRange()>=seasonList.get(i).getRange()){
                    mergeResult.get(mergeResult.size()-1).setEndDate(seasonList.get(i).getEndDate());
                }else {
                    Season lastMergeResult = mergeResult.get(mergeResult.size()-1);
                    mergeResult.remove(mergeResult.get(mergeResult.size()-1));
                    seasonList.get(i).setStartDate(lastMergeResult.getStartDate());
                    mergeResult.add(seasonList.get(i));
                }
            }else {
                mergeResult.add(seasonList.get(i));
            }
        }// the mergeResult includes none overlapping seasons

        // so we need to remove those none overlapping seasons by look up the nonOverLappingSeasonIds list
        for(int i=0;i<mergeResult.size();i++){
            if(nonOverLappingSeasonIds.contains(mergeResult.get(i).getId())){
                mergeResult.remove(mergeResult.get(i));
            }
        }

        return mergeResult;
    }



    //msrivathanakul@homeaway.com



    public static void main(String[] args){
        Season season1 = new Season(UUID.randomUUID(), 50, "Spring", new Date(2017, 2, 5), new Date(2017, 5, 10));
        Season season2 = new Season(UUID.randomUUID(), 60, "Summer", new Date(2017, 4, 5), new Date(2017, 8, 10));
        Season season3 = new Season(UUID.randomUUID(), 30, "Fall", new Date(2017, 8, 5), new Date(2017, 10, 10));
        Season season4 = new Season(UUID.randomUUID(), 30, "Winter", new Date(2017, 11, 1), new Date(2018, 0, 10));
        List<Season> seasons = new ArrayList<>();
        seasons.add(season1);
        seasons.add(season2);
        seasons.add(season3);
        seasons.add(season4);

        List<Season> mergeRes = combineOverlappingSeasons(seasons);
    }
}

class Season{
    private UUID id;
    private double amount;
    private String name;
    private Date startDate;
    private Date endDate;
    int range;
    Season(UUID id, double amount, String name, Date startDate, Date endDate){
        this.setId(id);
        this.setAmount(amount);
        this.setName(name);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    };
    public long getRange(){
        return getEndDate().getTime() - getStartDate().getTime();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}


