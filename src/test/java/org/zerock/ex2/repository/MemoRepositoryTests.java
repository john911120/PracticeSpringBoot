package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.entity.Memo;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    /*
    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }
    // JpaRepository Insert Test

    @Test
    public void testinsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample...."+i).build();
            memoRepository.save(memo);
        });
    }

    // JpaRepository Select Test
    @Test
    public void testSelect(){
        // 데이터베이스에 실존하는 데이터
        Long mno = 50L;

        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("-------------------------------------");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }
    }

    // getOne()어노테이션은 @Transactional을 사용한다.
    @Transactional
    @Test
    public void testSelect2() {
        Long mno = 77L;

        Memo memo = memoRepository.getOne(mno);
        System.out.println("-------------------------------------");
        System.out.println(memo);
    }

    // JpaRepository Update Test
    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
        System.out.println(memoRepository.save(memo));
    }

    // JpaRepository Delete Test
    @Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(mno);
    }
     */
    // 페이징 처리
    /*
    @Test
    public void testPageDefault(){
        // 1page 10 contents
        Pageable pageable = PageRequest.of(0,10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);

        System.out.println("--------------------------------------------");
        // 총 몇 페이지, 전체갯수, 현재 페이지 번호, 페이지당 데이터 수 , 다음페이지 존재 여부, 시작 페이지 여부
        System.out.println("Total Pages : "+result.getTotalPages());
        System.out.println("Total Count : "+result.getTotalElements());
        System.out.println("Page Number : " + result.getNumber());
        System.out.println("Page Size : " + result.getSize());
        System.out.println("has First Page :" + result.hasNext());
        System.out.println("First Page :" + result.isFirst());
        System.out.println("--------------------------------------------");

        System.out.println("--------------------------------------------");
        for(Memo memo : result.getContent()){
            System.out.println(memo);
        }
        System.out.println("--------------------------------------------");

    }

    // 정렬 조건 추가
    @Test
    public void testSort(){
        Sort sort1 = Sort.by("mno").descending();

        Pageable pageable = PageRequest.of(0,10,sort1);

        Page<Memo> result = memoRepository.findAll(pageable);

        result.get().forEach(memo -> {
            System.out.println(memo);
        });

    }
        @Test
    public void testQueryMethods(){
        List<Memo> list = memoRepository.findByMnoBetweenOrderByMnoDesc(70L,80L);

        for(Memo memo : list){
            System.out.println(memo);
        }
    }

    @Test
    // 간략한 메서드로 수정
    public void testQueryMethodWithPageable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(memo -> System.out.println(memo));
    }
     */

    // deleteby 으로 시작하는 삭제처리 쿼리
    @Commit
    @Transactional
    @Test
    public void testDeleteQueryMethods(){
        memoRepository.deleteMemoByMnoLessThan(10L);
    }

}
