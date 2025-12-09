#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>

void solve() {


	int n;
	std::cin >> n;

	

	while (n--) {
		int arr[11] = { 0, };
		for (int i = 0; i < 5; i++) {
			int now;
			std::cin >> now;
			arr[now]++;
		}
		int max = 0, min = 0, idx = 0, sum = 0;
		for (int i = 1; i <= 10; i++) {
			while (arr[i]-- > 0) {
				idx++;
				if (idx == 4) {
					max = i;
					sum += i;
				} else if (idx == 2) {
					min = i;
					sum += i;
				} else if (idx == 3) {
					sum += i;
				}
			}
		}
		if (max - min >= 4) {
			std::cout << "KIN\n";
		} else {
			std::cout << sum << "\n";
		}
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}