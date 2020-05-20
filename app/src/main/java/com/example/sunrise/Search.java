package com.example.sunrise;

import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Search extends AppCompatActivity
{

    ArrayList<SearchItem> searchItems = new ArrayList<>();

    public Search(SharedPreferences preferences) throws MalformedURLException {
        Set<String> likes = preferences.getStringSet("like", new HashSet<String>());

        for(String id : likes) {
            Log.d("찜하기", id);
        }

        String id1 = String.valueOf(1);
        searchItems.add(
                new SearchItem(
                        id1,
                        "열린장학금",
                        "한국청소년활동진흥원이 주관하는 성적을 지원기준에 포함하지 않고 가정형편에 어려움을 겪고 있는 고등학생을 대상으로한 제도 \n" +
                                "#저소득층 #고등학생",
                        likes.contains(id1),
                        Uri.parse("https://www.kywa.or.kr/business/business9.jsp"),
                        "2019-12-31"

                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );

        String id2 = String.valueOf(2);
        searchItems.add(
                new SearchItem(
                        id2,
                        "꿈사다리장학제도",
                        "교육부 교육정책복지과에서 주관하는 법정 저소득층 가정의 중학교 1학년을 대상으로 선발하여 5년간 장학금과 교육캠프등 맞춤형 교육 지원하는 제도\n"+
                        "#중학생 #맞춤형교육 #저소득층",
                        likes.contains(id2),
                        Uri.parse("https://www.kosaf.go.kr/ko/scholar.do?pg=scholarship05_17_01"),
                        "2019-10-01"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id3 = String.valueOf(3);
        searchItems.add(
                new SearchItem(
                        id3,
                        "드림장학금",
                        "한국 장학재단에서 주관하는 기초생활수급자 또는 차상위계층의 고등학교 졸업예정자로서 해외대학 입학 희망자에게 학업장려비를 지원하는 혜택. \n"+
                        "#저소득층 #학업장려비 #고등학생",
                        likes.contains(id3) ,
                        Uri.parse("https://www.kosaf.go.kr/ko/scholar.do?pg=scholarship05_13_01"),
                        "2019-09-28"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id4 = String.valueOf(4);
        searchItems.add(
                new SearchItem(
                        id4,
                        "고교 취업 연계 장려금",
                        "한국장학재단에서 주관하는 중소기업에 취업하는 고교 3학년들(졸업예정자)에게 장려금을 지원하는 혜택\n"+
                        "#고등학생 #장려금 #취업 #미래준비",
                        likes.contains(id4),
                        Uri.parse("https://www.gov.kr/portal/service/serviceInfo/134200000047"),
                        "2019-11-24"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id5 = String.valueOf(5);
        searchItems.add(
                new SearchItem(
                        id5,
                        "희망 SOS 장학금",
                        "갑작스러운 가정의 위기로 인해 경제적 어려움에 처한 위기가정 청소년과 대학생에게 지속적으로 학업에 임할 수 있도록 학업 장려금을 지원하는 혜택\n"+
                        "#위기 #청소년 #대학생 #학업장려금",
                        likes.contains(id5),
                        Uri.parse("https://www.hissf.or.kr/Programs/user/scholarship/school/sos.asp"),
                        "2019-11-30"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id6 = String.valueOf(6);
        searchItems.add(
                new SearchItem(
                        id6,
                        "서울꿈길 장학금",
                        "학업 의지가 강한 학교 밖 청소년이 자신의 진로탐색과 활동을 통해 스스로 미래를 준비할 수 있도록 학업장려금을 지원하는 혜택\n"+
                             "#체험 #학업장려금 #학교밖청소년 #자퇴",
                        likes.contains(id6),
                        Uri.parse("https://www.hissf.or.kr/Programs/user/scholarship/school/dream.asp"),
                        "2020-08-08"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id7 = String.valueOf(7);
        searchItems.add(
                new SearchItem(
                        id7,
                        "아동발달지원계좌 지원",
                        "보건복지부 아동권리과에서 하는 저소득층 아동의 사회진출 시 학자금, 주거마련 등에 소요되는 초기비용 마련을 위해 자산을 형성해주는 혜택\n"+
                                "#자산 #아동 #미래 #저소득층",
                        likes.contains(id7),
                        Uri.parse("https://www.adongcda.or.kr/"),
                        "2019-09-28"

                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id8 = String.valueOf(8);
        searchItems.add(
                new SearchItem(
                        id8,
                        "특성화고등학생 장학금",
                        "특성화고등학교 학생에게 교육비(수업료)를 지원하여 학비 걱정없이 공부할 수 있는 희망의 사다리를 마련해주는 혜택\n"+
                        "#특성화고 #학비 #전공",
                        likes.contains(id8),
                        Uri.parse("https://www.gov.kr/portal/service/serviceInfo/738000000006"),
                        "2019-12-31"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id9 = String.valueOf(9);
        searchItems.add(
                new SearchItem(
                        id9,
                        "서울희망 고교 장학금",
                        "저소득층 가정의 고등학생에게 수업료와 학교운영비를 지원하여 교육비 부담을 줄이고, 경제적인 이유로 학업을 중단하지 않도록 지원해주는 혜택\n"+
                                "#저소득층 #학비지원 #학구열",
                        likes.contains(id9),
                        Uri.parse("http://www.hissf.or.kr/Programs/user/scholarship/school/hiseoul_highschool.asp"),
                        "2020-05-01"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id10 = String.valueOf(10);
        searchItems.add(
                new SearchItem(
                        id10,
                        "청계천 꿈디딤 장학금",
                        "청계천에 모인 행운의 동전을 통해 조성된 장학금으로 경제적으로 어려운 환경이지만 학업의지가 강한 특성화 고등학교 2학년 학생들을 2년간 지원해주는 혜택\n"+
                                "#특성화고 #저소득층 #청계천",
                        likes.contains(id10),
                        Uri.parse("http://www.hissf.or.kr/Programs/user/scholarship/school/cheonggyecheon.asp"),
                        "2019-12-18"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id11 = String.valueOf(11);
        searchItems.add(
                new SearchItem(
                        id11,
                        "고졸 후학습자 장학금",
                        "현 재직기업 유형 및 규모에 따라 등록금을 지원해주는 혜택\n"+
                                "#조기취업 #등록금 #선취업후진학",
                        likes.contains(id11),
                        Uri.parse("http://www.kosaf.go.kr/?fbclid=IwAR37EgvIiPXJndnW8fwTghkOuwNn-EsOwKMPxx-EM9_Ck2v7cPXx8t6QoMo"),
                        "2019-10-8"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
        String id12 = String.valueOf(12);
        searchItems.add(
                new SearchItem(
                        id12,
                        "파란사다리",
                        "해외 우수대학에서 약 4주 간의 해외연수 기회를 제공하고 해외연수를 위한 현지 교육비, 왕복 항공비 및 기숙사비 등 지원해주는 혜택\n"+
                                "#유학 #대학생 #외국 #대학",
                        likes.contains(id12),
                        Uri.parse("http://www.kosaf.go.kr/?fbclid=IwAR2NswSSYcjv70aaqjOR23_dKuumBlNUmbPQ6os5ytETbDcqcthJS2LrB7I"),
                        "2019-11-01"
                        // 이 ID가 Preference의 like Set에 저장되어있으면 true, 아니면 false
                )
        );
    }


    public ArrayList<SearchItem> search(String text) {
        if(text == null || text.equals("")) {
            return searchItems;
        }

        ArrayList<SearchItem> result = new ArrayList<>();
        // 파라미터로 온 text 가 SearchItem의 title이나 text에 포함되어있으면
        // result 배열리스트에 추가
        for(SearchItem item : searchItems) {
            if(item.title.contains(text) || item.text.contains(text)) {
                result.add(item);
            }
        }
        return result;
    }
}