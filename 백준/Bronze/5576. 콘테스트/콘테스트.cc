#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>


void solve() {

	int w[101] = { 0, }, k[101] = { 0, };

	for (int i = 0; i < 10; ++i) {
		int now;
		std::cin >> now;
		w[now]++;
	}
	for (int i = 0; i < 10; ++i) {
		int now;
		std::cin >> now;
		k[now]++;
	}
	int w_sum = 0, k_sum = 0, w_cnt = 0, k_cnt = 0;
	for (int i = 100; i >= 0; --i) {
		if (w[i]) {
			while (w_cnt < 3 && w[i]) {
				w_cnt++;
				w_sum += i;
				w[i]--;
			}
		}
		if (k[i]) {
			while (k_cnt < 3 && k[i]) {
				k_cnt++;
				k_sum += i;
				k[i]--;
			}
		}
	}
	std::cout << w_sum << " " << k_sum << "\n";

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}