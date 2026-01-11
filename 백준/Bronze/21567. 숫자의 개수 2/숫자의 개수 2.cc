#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


void solve() {

	long long a, b, c;
	std::cin >> a >> b >> c;

	long long tmp = a * b * c;
	int cnt[10] = { 0, };
	while (tmp) {
		cnt[tmp % 10]++;
		tmp /= 10;
	}

	for (int i = 0; i < 10; i++) {
		std::cout << cnt[i] << "\n";
	}

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}