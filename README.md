# traclet
경량화된 실시간 이벤트 스트림 콜렉터 유틸리티

## 개요
- 실시간으로 들어오는 이벤트 스트림(채팅, 페이지 뷰 등)을 일정 시간 단위로 통계적으로 집계
- 프로그램 실행 도중 발생하는 다양한 이벤트(채팅, 아이템 획득 등)를 부하 없이 가볍게 수집
- Kafka, Redis 등 복잡한 외부 의존성 없이도 통계/알림 제공 가능
- 향후 관리자 대시보드, 부정 행위 탐지 시스템과 연동될 수 있도록 확장 가능

## 주요 기능
- 이벤트 수신
- 지정 시간 간격 집계
- 집계 수치 초과 시 알람

todo
- 슬라이딩 윈도우 평균치 계산
- 이벤트 호출 속도 분석

## 사용 방법


## License
This project is licensed under the MIT License – see the [LICENSE](./LICENSE) file for details.
